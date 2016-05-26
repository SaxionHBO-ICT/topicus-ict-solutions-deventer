package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import nl.vanlaar.bart.topid.Activity.MainActivity.MainActivity;
import nl.vanlaar.bart.topid.R;

/**
 * Created by Sander on 25-5-2016.
 */
public class HomescreenActivity extends AppCompatActivity {
    TextView uitloggen;
    TextView inbox;
    TextView ideeën;
    TextView instellingen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        uitloggen = (TextView) findViewById(R.id.tv_homescreen_uitloggen);
        uitloggen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomescreenActivity.this, LoginActivity.class);
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
        instellingen = (TextView) findViewById(R.id.tv_homescreen_instellingen);
        instellingen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomescreenActivity.this, InstellingenActivity.class);
                startActivity(intent);
            }
        });
    }


}
