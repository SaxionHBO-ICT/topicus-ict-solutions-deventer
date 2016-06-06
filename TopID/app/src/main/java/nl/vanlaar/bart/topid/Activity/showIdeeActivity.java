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
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        int ideePositie = intent.getIntExtra(EXTRA_IDEE, -1);
        idee = IdeeënLijst.getInstance().getIdeeën().get(ideePositie);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_idee);



        tv_show_idee_name = (TextView) findViewById(R.id.tv_show_idee_name);
        tv_show_idee_name.setText(idee.getTitle());

        tvPosterText_showIdee = (TextView) findViewById(R.id.tvPosterText_showIdee);
        tvPosterText_showIdee.setText(idee.getMainText());

        iv_ImagePost_showIdee = (ImageView) findViewById(R.id.iv_ImagePost_showIdee);
        if(idee.getPlaatje()!=null){
            iv_ImagePost_showIdee.setImageBitmap(idee.getPlaatje());
        }



        tvPosterName_showPostcount = (TextView) findViewById(R.id.tvPosterName_showPostcount);
        tvPosterName_showPostcount.setText("Postcount: " + MainActivity.LOGGED_IN_USER.getPostcount());
        ivPosterImage_showIdee = (ImageView) findViewById(R.id.ivPosterImage_showIdee);
        ivPosterImage_showIdee.setImageResource(MainActivity.LOGGED_IN_USER.getTempImage());
      //  ivPosterImage_showIdee.setImageBitmap(MainActivity.LOGGED_IN_USER.getProfileImage());

        menuButton = (ImageView) findViewById(R.id.iv_show_idee_menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowIdeeActivity.this, HomescreenActivity.class);
                startActivity(intent);
            }
        });
        backArrow = (ImageView) findViewById(R.id.iv_iedeeën_toolbar_backbutton);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            finish();
            }
        });




        ideeImage  = (ImageView) findViewById(R.id.iv_ImagePost_showIdee);
        ideeImage.setClickable(true);
        ideeImage_FullScreen = (ImageView) findViewById(R.id.iv_ImagePost_FullScreen_showIdee);
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
                upvoteButton.setText(idee.getPostPoints() + " Upvotes");
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
