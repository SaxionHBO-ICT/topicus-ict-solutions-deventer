package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;

import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;
import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.ReactiesAdapter;

public class ShowIdeeActivity extends AppCompatActivity {
    public static final String EXTRA_IDEE = "idee";
    public static final String FULL_SCREEN_PICTURE ="FULL SCREEN PICTURE" ;
    private ListView commentListView;
    private ReactiesAdapter adapter;
    private Button btReageer;
    private ScrollView svReacties;
    private Button upvoteButton;
    private Toolbar toolbar;
    private ImageView backArrow;
    private ImageView menuButton;
    private ImageView ideeImage;
    private ImageView ideeImage_FullScreen;
    private Idee idee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_idee);






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

        Intent intent = getIntent();
        int ideePositie = intent.getIntExtra(EXTRA_IDEE, -1);
        idee = IdeeënLijst.getIdeeënLijst().get(ideePositie);


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


        upvoteButton = (Button) findViewById(R.id.btUpvote_showIdee);
        upvoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nieuwGetal = Integer.parseInt(upvoteButton.getText().toString()) + 1;
                upvoteButton.setText(nieuwGetal + "");
            }
        });

        commentListView = (ListView) findViewById(R.id.lvReacties_showIdee);
        adapter = new ReactiesAdapter(this, ideePositie);

        commentListView.setAdapter(adapter);
        btReageer = (Button) findViewById(R.id.btReageer_showIdee);


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
