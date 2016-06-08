package nl.vanlaar.bart.topid.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import nl.vanlaar.bart.topid.Model.User;
import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.VolgIdeeAdapter;

public class VolgIdeeActivity extends AppCompatActivity {
    ListView listView;
    VolgIdeeAdapter adapter;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volg_idee);

        user = new User("henk");
        listView = (ListView) findViewById(R.id.lv_volg_idee_list);
        adapter = new VolgIdeeAdapter(this, R.layout.activity_volg_idee, user.getGevolgeIdeeën());
    }
}
