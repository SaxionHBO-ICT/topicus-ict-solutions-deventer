package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
 * de showIdeeActivity laat een idee zien van de MainActivity in meerr detail en geeft de mogelijkheid om
 * meer
 * dit idee te upvoten, te reageren op heet
 */
public class ShowIdeeActivity extends AppCompatActivity {
    public static final String EXTRA_IDEE = "idee";
    public static final String FULL_SCREEN_PICTURE ="FULL SCREEN PICTURE" ;
    private ReactiesAdapter adapter;
    private Button btReageer;
    private ScrollView svReacties;
    private Button upvoteButton;
    private Toolbar toolbar;
    private ImageView backArrow;
    private ImageView menuButton;
    private ImageView ideeImage;
    private ImageView ideeImage_FullScreen;
    private ImageView ivPosterImage_showIdee;
    private TextView tvPosterName_showPostcount;
    private TextView tv_show_idee_name;
    private TextView tvPosterText_showIdee;
    private ImageView iv_ImagePost_showIdee;
    private Idee idee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_idee);

        //set our custom toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //full het idee met het meegegeven idee
        Intent intent = getIntent();
        int ideePositie = intent.getIntExtra(EXTRA_IDEE, -1);
        idee = IdeeënLijst.getInstance().getIdeeën().get(ideePositie);

        //kopelen van views
        tv_show_idee_name = (TextView) findViewById(R.id.tv_show_idee_name);
        tvPosterText_showIdee = (TextView) findViewById(R.id.tvPosterText_showIdee);
        iv_ImagePost_showIdee = (ImageView) findViewById(R.id.iv_ImagePost_showIdee);
        tvPosterName_showPostcount = (TextView) findViewById(R.id.tvPosterName_showPostcount);
        ivPosterImage_showIdee = (ImageView) findViewById(R.id.ivPosterImage_showIdee);
        menuButton = (ImageView) findViewById(R.id.iv_show_idee_menu);
        backArrow = (ImageView) findViewById(R.id.iv_iedeeën_toolbar_backbutton);
        ideeImage  = (ImageView) findViewById(R.id.iv_ImagePost_showIdee);
        ideeImage_FullScreen = (ImageView) findViewById(R.id.iv_ImagePost_FullScreen_showIdee);

        //set alle views met info van het idee
        tv_show_idee_name.setText(idee.getTitle());
        tvPosterText_showIdee.setText(idee.getMainText());
        if(idee.getPlaatje()!=null){
            iv_ImagePost_showIdee.setImageBitmap(idee.getPlaatje());
        }
        tvPosterName_showPostcount.setText("Postcount: " + MainActivity.LOGGED_IN_USER.getPostcount());
        ivPosterImage_showIdee.setImageResource(MainActivity.LOGGED_IN_USER.getTempImage());

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




        ////////////////////////////////////////////////////////////////////////
        ideeImage.setClickable(true);
        ideeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ideeImage.getVisibility()== View.VISIBLE) {
                    ideeImage.setVisibility(View.INVISIBLE);
                    ideeImage_FullScreen.setImageDrawable(ideeImage.getDrawable());
                    ideeImage_FullScreen.setBackgroundColor(Color.WHITE);
                    ideeImage_FullScreen.setVisibility(View.VISIBLE);
                }
            }
        });
        ////////////////////////////////////////////////////////////////
        ideeImage_FullScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ideeImage_FullScreen.setVisibility(View.GONE);
                ideeImage.setVisibility(View.VISIBLE);
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
                intent.putExtra(EXTRA_IDEE,getIntent().getIntExtra(EXTRA_IDEE,-1));
                startActivity(intent);
            }
        });

    }

}
