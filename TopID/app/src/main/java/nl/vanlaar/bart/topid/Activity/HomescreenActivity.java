package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import nl.vanlaar.bart.topid.Database.DatabaseHelper;
import nl.vanlaar.bart.topid.R;

/**
 * Created by Sander on 25-5-2016.
 */

/**
 * De HomescreenActivity laat een menu zien met de mogelijkheden van de app
 */
public class HomescreenActivity extends AppCompatActivity {
    private TextView uitloggen;
    private TextView inbox;
    private TextView ideeën;
    private TextView gevolgdeIdeeën;
    private Toolbar toolbar;
    private TextView tvIngelogdeUser;
    private ImageView userImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_homescreen);

        //set onze custom toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //set de naam van de ingelogte user
        tvIngelogdeUser = (TextView) findViewById(R.id.tv_homescreen_user_name);
        tvIngelogdeUser.setText(MainActivity.LOGGED_IN_USER.getName());

        //set de profiel foto van de ingelogte user
        userImage = (ImageView) findViewById(R.id.iv_homescreen_user);
        userImage.setImageResource(MainActivity.LOGGED_IN_USER.getTempImage());



        //alle opties in het menu met onClickListners
        uitloggen = (TextView) findViewById(R.id.tv_homescreen_uitloggen);
        uitloggen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);
            }
        });
        inbox = (TextView) findViewById(R.id.tv_homescreen_inbox);
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomescreenActivity.this, InboxActivity.class);
                startActivity(intent);
            }
        });
        ideeën = (TextView) findViewById(R.id.tv_homescreen_ideeën);
        ideeën.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomescreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        gevolgdeIdeeën = (TextView) findViewById(R.id.tv_homescreen_gevolgdeIdeeën);
        gevolgdeIdeeën.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomescreenActivity.this, VolgIdeeActivity.class);
                startActivity(intent);
            }
        });
    }


}
