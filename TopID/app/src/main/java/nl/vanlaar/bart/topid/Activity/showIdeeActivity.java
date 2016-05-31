package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.ReactiesAdapter;

public class ShowIdeeActivity extends AppCompatActivity {
    public static final String EXTRA_IDEE = "idee";
    private ListView commentListView;
    private ReactiesAdapter adapter;
    private Button btReageer;
    private ScrollView svReacties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_idee);

        Intent intent = getIntent();
        int ideePositie = intent.getIntExtra(EXTRA_IDEE, -1);

        commentListView = (ListView) findViewById(R.id.lvReacties_showIdee);
        adapter = new ReactiesAdapter(this, ideePositie);
        if (adapter == null){
            System.out.println("test2");
        }
        if (commentListView == null){
            System.out.println("test1");
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secondary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //starting of activity's
        if (id == R.id.topbar_menu) {
            Intent intent = new Intent(ShowIdeeActivity.this, HomescreenActivity.class);
            startActivity(intent);
        }
        if (id == R.id.topbar_inbox){
            Intent intent = new Intent(ShowIdeeActivity.this, InboxActivity.class);
            startActivity(intent);
        }
        if (id == R.id.topbar_uitloggen){
            Intent intent = new Intent(ShowIdeeActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if (id == R.id.topbar_instellingen){
            Intent intent = new Intent(ShowIdeeActivity.this, InstellingenActivity.class);
            startActivity(intent);
        }
        if (id == R.id.topbar_ideeën){
            Intent intent = new Intent(ShowIdeeActivity.this, MainActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}
