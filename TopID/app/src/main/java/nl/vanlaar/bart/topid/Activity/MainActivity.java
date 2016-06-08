package nl.vanlaar.bart.topid.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;
import nl.vanlaar.bart.topid.Model.User;
import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.IdeeënAdapter;
import nl.vanlaar.bart.topid.View.KlachtenAdapter;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Idee> ideeënLijst;

    public static User LOGGED_IN_USER = new User("henk",R.drawable.gabenewell,0);
    public static final int IDEE_REQUESTCODE = 1337;
    public static boolean dataChanged = false;
    public static boolean ingelogd = true;
    private ListView lvIdeeën;
    private FloatingActionButton fab;
    private static IdeeënAdapter ideeAdapter;
    private static KlachtenAdapter klachtenAdapter;
    private Context context;
    private Spinner spinnerSort;
    private Toolbar toolbar;
    private CheckBox nieuwBox;
    private CheckBox bestBox;
    private ImageView backArrow;
    private ImageView menuButton;


    public MainActivity(Context context) {
        this.context = context;
    }

    public MainActivity() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ideeAdapter = new IdeeënAdapter(this, R.layout.fragment_main, IdeeënLijst.getInstance().sortByIdee());
        klachtenAdapter = new KlachtenAdapter(this, R.layout.fragment_main, IdeeënLijst.getInstance().sortByKlacht());
        ideeënLijst = IdeeënLijst.getInstance().getIdeeën();
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setAdapter(-1);
        bestBox = (CheckBox) findViewById(R.id.cb_beste);
        nieuwBox = (CheckBox) findViewById(R.id.cb_nieuw);
        bestBox.setChecked(true);
        bestBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bestBox.setChecked(true);
                nieuwBox.setChecked(false);
            }
        });
        nieuwBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nieuwBox.setChecked(true);
                bestBox.setChecked(false);
            }
        });

        menuButton = (ImageView) findViewById(R.id.iv_mainActivity_menu);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomescreenActivity.class);
                startActivity(intent);
            }
        });
        backArrow = (ImageView) findViewById(R.id.iv_iedeeën_toolbar_backbutton);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        fab = (FloatingActionButton) findViewById(R.id.fab);
        lvIdeeën = (ListView) findViewById(R.id.lvIdeeën);
        spinnerSort = (Spinner) findViewById(R.id.spinner_lijst_sorteer);

        if (ingelogd == false) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }


        lvIdeeën.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ShowIdeeActivity.class);
                intent.putExtra(ShowIdeeActivity.EXTRA_IDEE, position);
                startActivity(intent);
            }
        });
        final ArrayAdapter<CharSequence> adapterSort = ArrayAdapter.createFromResource(this, R.array.sort_lijst, android.R.layout.simple_spinner_item);
        spinnerSort.setAdapter(adapterSort);

        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                setAdapter(position);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                /*
                parent.setSelection(0);
                ideeën = IdeeënLijst.sortByIdee();
                ideeAdapter.notifyDataSetChanged();
                */
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MakeIdeeActivity.class);

                // start de make idee activity
                startActivity(intent);

                // sluit de mainactivity af.
                finish();
            }
        });


    }


    @Override
    protected void onResume() {
        super.onResume();



    }



    private void setAdapter(int position_in_spinner){
        if (position_in_spinner == 0) {

            lvIdeeën.setAdapter(ideeAdapter);
        }
        if (position_in_spinner == 1) {
            lvIdeeën.setAdapter(klachtenAdapter);
        }
    }

}
