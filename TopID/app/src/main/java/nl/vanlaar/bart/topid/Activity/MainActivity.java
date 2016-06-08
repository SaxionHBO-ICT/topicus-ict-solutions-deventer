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
        setContentView(R.layout.activity_main);

        //als er geen user ingelogt is ga dan terug naar de login pagina
        if (ingelogd == false) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

        //set onze custom toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //koppelen aan views
        bestBox = (CheckBox) findViewById(R.id.cb_beste);
        nieuwBox = (CheckBox) findViewById(R.id.cb_nieuw);
        menuButton = (ImageView) findViewById(R.id.iv_mainActivity_menu);
        backArrow = (ImageView) findViewById(R.id.iv_iedeeën_toolbar_backbutton);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        lvIdeeën = (ListView) findViewById(R.id.lvIdeeën);
        spinnerSort = (Spinner) findViewById(R.id.spinner_lijst_sorteer);

        //initeer de adapters en de iedeeënlijst
        ideeAdapter = new IdeeënAdapter(this, R.layout.fragment_main, IdeeënLijst.getInstance().sortByIdee());
        klachtenAdapter = new KlachtenAdapter(this, R.layout.fragment_main, IdeeënLijst.getInstance().sortByKlacht());
        ideeënLijst = IdeeënLijst.getInstance().getIdeeën();

        //set de adapter van de spinner
        final ArrayAdapter<CharSequence> adapterSort = ArrayAdapter.createFromResource(this, R.array.sort_lijst, android.R.layout.simple_spinner_item);
        spinnerSort.setAdapter(adapterSort);

        //start de activity met de iedeeën
        lvIdeeën.setAdapter(ideeAdapter);

        //Als een checkbox wordt aangevinkt zet de ander checkbox uit en laat de juist listview zien
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

        //als er op de menu knop gedrukt wordt ga naar het menu
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HomescreenActivity.class);
                startActivity(intent);
            }
        });

        //als er op de terug knop wordt gedrukt ga naar de vorige activity
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //als er op een idee wordt gedrukt start de showIdeeActivity met het idee
        lvIdeeën.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ShowIdeeActivity.class);
                intent.putExtra(ShowIdeeActivity.EXTRA_IDEE, position);
                startActivity(intent);
            }
        });

        //als een element in de spinner wordt aangedrukt zet dan de juist adapter aan de listview
        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    lvIdeeën.setAdapter(ideeAdapter);
                }
                if (position == 1) {
                    lvIdeeën.setAdapter(klachtenAdapter);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //DO NOTHING
            }
        });

        //als de knop ingedrukt is ga naar de MakeIdeeActivity
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
}
