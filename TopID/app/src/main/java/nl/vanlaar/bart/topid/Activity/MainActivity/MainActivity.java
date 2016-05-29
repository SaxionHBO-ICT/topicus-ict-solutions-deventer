package nl.vanlaar.bart.topid.Activity.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.Activity.HomescreenActivity;
import nl.vanlaar.bart.topid.Activity.LoginActivity;
import nl.vanlaar.bart.topid.Activity.MakeIdeeActivity;
import nl.vanlaar.bart.topid.Activity.showIdeeActivity;
import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;
import nl.vanlaar.bart.topid.Model.User;
import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.IdeeënAdapter;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Idee> ideeën = IdeeënLijst.getIdeeënLijst();
    public static final User LOGGED_IN_USER = new User("henk",R.drawable.gabenewell);
    public static final int IDEE_REQUESTCODE = 666;
    public static boolean dataChanged = false;
    public static boolean ingelogd = true;
    private ListView lvIdeeën;
    private FloatingActionButton fab;
    private IdeeënAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        lvIdeeën = (ListView) findViewById(R.id.lvIdeeën);

        if ( ingelogd == false){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }




        adapter = new IdeeënAdapter(this,R.layout.fragment_main, ideeën);
        lvIdeeën.setAdapter(adapter);
        lvIdeeën.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, showIdeeActivity.class);
                startActivity(intent);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MakeIdeeActivity.class);
                startActivityForResult(intent, IDEE_REQUESTCODE);
            }
        });


}
        on

    @Override
    protected void onResume() {
        adapter.notifyDataSetChanged();
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.topbar_menu) {
            Intent intent = new Intent(this, HomescreenActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == IDEE_REQUESTCODE){
                Idee idee = data.getBundleExtra();
                ideeën.add(idee);
                notifyAdapter();

            }
        }

    }
    */
}
