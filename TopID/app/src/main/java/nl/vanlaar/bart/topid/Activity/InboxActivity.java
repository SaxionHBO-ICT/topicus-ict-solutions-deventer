package nl.vanlaar.bart.topid.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.Model.Comment;
import nl.vanlaar.bart.topid.Model.CommentList;
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

        listView = (ListView) findViewById(R.id.lv_inbox_list);
        inboxAdapter = new InboxAdapter(this);
        listView.setAdapter(inboxAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }


}
