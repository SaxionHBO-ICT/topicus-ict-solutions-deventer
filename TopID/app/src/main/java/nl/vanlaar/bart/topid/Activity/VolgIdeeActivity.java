package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import nl.vanlaar.bart.topid.Model.User;
import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.VolgIdeeAdapter;

public class VolgIdeeActivity extends AppCompatActivity {
    private ListView listView;
    private VolgIdeeAdapter adapter;
    private User user;
    private ImageView backArrow;
    private ImageView menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volg_idee);

        //koppelen aan view
        backArrow = (ImageView) findViewById(R.id.iv_volg_idee_toolbar_backbutton);
        menuButton = (ImageView) findViewById(R.id.iv_volg_idee_menu);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VolgIdeeActivity.this, HomescreenActivity.class);
                startActivity(intent);
            }
        });

        user = new User("henk");
        listView = (ListView) findViewById(R.id.lv_volg_idee_list);
        adapter = new VolgIdeeAdapter(this, R.layout.activity_volg_idee, user.getGevolgeIdeeën());
    }
}
