package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.InboxAdapter;

/**
 * Created by Sander on 25-5-2016.
 */
public class InboxActivity extends AppCompatActivity {
    private ListView listView;
    private InboxAdapter inboxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);

        listView = (ListView) findViewById(R.id.lv_inbox_list);
        inboxAdapter = new InboxAdapter(this);
        listView.setAdapter(inboxAdapter);
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
