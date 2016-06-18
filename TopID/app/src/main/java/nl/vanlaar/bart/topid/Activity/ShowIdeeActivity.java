package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;
import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.ReactiesAdapter;

/**
 * de showIdeeActivity laat een idee zien van de MainActivity in meer detail en geeft de mogelijkheid om
 * dit idee te upvoten en te reageren op het idee
 */
public class ShowIdeeActivity extends AppCompatActivity {
    public static final String EXTRA_IDEE = "idee";
    public static final String EXTRA_KLACHT = "klacht";
    private ReactiesAdapter adapter;
    private Button btReageer;
    private ScrollView svReacties;
    private Button upvoteButton;
    private Toolbar toolbar;
    private ImageView backArrow;
    private ImageView menuButton;
    private ImageView ideeImage;

    private ImageView ivPosterImage_showIdee;
    private TextView tvPosterName_showPostcount;
    private TextView tv_show_idee_name;
    private TextView tvPosterText_showIdee;
    private TextView tvPosterName_showIdee;

    private int ideePositieIdee;
    private int ideePositieKlacht;
    private Idee idee;
    private TextView tvPostTijdenDate_showIdee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_idee);

        //set our custom toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //full het idee met het meegegeven idee

        ideePositieIdee = getIntent().getIntExtra(EXTRA_IDEE,-1);
         ideePositieKlacht = getIntent().getIntExtra(EXTRA_KLACHT,-1);

        Log.d("idee post/ klacht post","" + ideePositieIdee+ideePositieKlacht);
        if(ideePositieIdee>-1) {
            idee = IdeeënLijst.getInstance().getIdeeën().get(ideePositieIdee);
        } else if(ideePositieKlacht >-1){
            idee = IdeeënLijst.getInstance().getKlachten().get(ideePositieKlacht);
        }

        //kopelen van views
        tv_show_idee_name = (TextView) findViewById(R.id.tv_show_idee_name);
        tvPosterText_showIdee = (TextView) findViewById(R.id.tvPosterText_showIdee);
        tvPosterName_showPostcount = (TextView) findViewById(R.id.tvPosterName_showPostcount);
        ivPosterImage_showIdee = (ImageView) findViewById(R.id.ivPosterImage_showIdee);
        menuButton = (ImageView) findViewById(R.id.iv_show_idee_menu);
        backArrow = (ImageView) findViewById(R.id.iv_iedeeën_toolbar_backbutton);
        ideeImage  = (ImageView) findViewById(R.id.iv_ImagePost_showIdee);
        tvPosterName_showIdee = (TextView) findViewById(R.id.tvPosterName_showIdee);

        tvPostTijdenDate_showIdee = (TextView) findViewById(R.id.tvPostTijdenDate_showIdee);


        //set alle views met info van het idee
        tv_show_idee_name.setText(idee.getTitle());
        tvPosterText_showIdee.setText(idee.getMainText());
        if(idee.getPlaatje()!=null) {
            ideeImage.setImageBitmap(idee.getPlaatje());
        }
        tvPosterName_showPostcount.setText("Postcount: " + MainActivity.LOGGED_IN_USER.getPostcount());
        ivPosterImage_showIdee.setImageResource(idee.getPoster().getTempImage());
        tvPostTijdenDate_showIdee.setText(idee.getidee_Datum());
        tvPosterName_showIdee.setText(idee.getPoster().getName());



        //als er op de menu knop wordt gedrukt ga dan naar het menu
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowIdeeActivity.this, HomescreenActivity.class);
                startActivity(intent);
            }
        });

        //als er op de terug knop wordt gedrukt ga dan terug naar de vorige activity
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });






        upvoteButton = (Button) findViewById(R.id.btUpvote);
        upvoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idee.addPostPoint();
                upvoteButton.setText(idee.getPostPoints() + " Upvote(s)");
            }
        });



        btReageer = (Button) findViewById(R.id.btReacties);


        btReageer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowIdeeActivity.this, ReageerActivity.class);
                if(ideePositieIdee >-1){
                    intent.putExtra(EXTRA_IDEE,ideePositieIdee);
                }else {
                    intent.putExtra(EXTRA_KLACHT,ideePositieKlacht);
                }
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
