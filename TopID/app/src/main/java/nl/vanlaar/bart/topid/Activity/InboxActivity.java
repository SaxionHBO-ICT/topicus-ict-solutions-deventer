package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.InboxAdapter;

/**
 * De InboaxActivity laat de gebruiker zijn inbox zien.
 */
public class InboxActivity extends AppCompatActivity {
    private ListView listView;
    private InboxAdapter inboxAdapter;
    private Toolbar toolbar;
    private ImageView backArrow;
    private ImageView menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        //set onze custom toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //koppelen aan views
        listView = (ListView) findViewById(R.id.lv_inbox_list);
        menuButton = (ImageView) findViewById(R.id.iv_inbox_menu);
        backArrow = (ImageView) findViewById(R.id.iv_inbox_toolbar_backbutton);

        //als de menu knop is ingedrukt ga dan naar het menu
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InboxActivity.this, HomescreenActivity.class);
                startActivity(intent);
            }
        });

        //als de terug knop is ingedrukt ga dan naar de vorige activity
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              finish();
            }
        });

        inboxAdapter = new InboxAdapter(this);
        listView.setAdapter(inboxAdapter);

        //als er op een een idee wordt gedrukt laat dat idee zien
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(InboxActivity.this, ShowIdeeActivity.class);
                intent.putExtra(ShowIdeeActivity.EXTRA_IDEE, position);
                startActivity(intent);
            }
        });
    }
}
