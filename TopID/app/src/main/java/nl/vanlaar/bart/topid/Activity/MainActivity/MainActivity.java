package nl.vanlaar.bart.topid.Activity.MainActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.Activity.HomescreenActivity;
import nl.vanlaar.bart.topid.Activity.LoginActivity;
import nl.vanlaar.bart.topid.Activity.MakeIdeeActivity;
import nl.vanlaar.bart.topid.Activity.ShowIdeeActivity;
import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;
import nl.vanlaar.bart.topid.Model.User;
import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.IdeeënAdapter;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<Idee> ideeën;
    public static final User LOGGED_IN_USER = new User("henk",R.drawable.gabenewell);
    public static final int IDEE_REQUESTCODE = 666;
    public static boolean dataChanged = false;
    public static boolean ingelogd = false;
    private ListView lvIdeeën;
    private FloatingActionButton fab;
    private IdeeënAdapter adapter = null;
    private Context context;
    private Spinner spinnerSort;
    private Toolbar toolbar;

    public MainActivity(Context context){
        this.context = context;
    }
    public MainActivity(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ideeën = IdeeënLijst.sortByIdee();
        Log.d("lijst:      ", ideeën.toString());
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.rgb(255,180,56));
         setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        lvIdeeën = (ListView) findViewById(R.id.lvIdeeën);
        spinnerSort = (Spinner) findViewById(R.id.spinner_lijst_sorteer);

        if ( ingelogd == false){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }




        adapter = new IdeeënAdapter(this,R.layout.fragment_main, ideeën);
        lvIdeeën.setAdapter(adapter);
        lvIdeeën.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ShowIdeeActivity.class);
                intent.putExtra(ShowIdeeActivity.EXTRA_IDEE, position);
                startActivity(intent);
            }
        });
        final ArrayAdapter<CharSequence> adapterSort = ArrayAdapter.createFromResource(this,R.array.sort_lijst,android.R.layout.simple_spinner_item);
        spinnerSort.setAdapter(adapterSort);

        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1){
                    Log.d("position",  "" + position);
                    ideeën = IdeeënLijst.sortByKlacht();
                    adapter.notifyDataSetChanged();

                    Log.d("size   ", "" + ideeën.size());
                }
                if(parent.getItemAtPosition(position).toString().equalsIgnoreCase("Ideeën")){
                    ideeën = IdeeënLijst.sortByIdee();
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                /*
                parent.setSelection(0);
                ideeën = IdeeënLijst.sortByIdee();
                adapter.notifyDataSetChanged();
                */
            }
        });




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MakeIdeeActivity.class);
                //startActivity(intent);
                startActivityForResult(intent, IDEE_REQUESTCODE);
            }
        });


}


    @Override
    protected void onResume() {
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == IDEE_REQUESTCODE){
                adapter.notifyDataSetChanged();

            }
        }

    }





 public IdeeënAdapter getIdeeënAdapter(){
     return adapter;
 }
}
