package nl.vanlaar.bart.topid.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.Model.Comment;
import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;
import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.ReactiesAdapter;

/**
 * De reageer activity laat de gebruiker een reactie plaatsen op een idee
 */
public class ReageerActivity extends AppCompatActivity {

    private Button btPlaatsReactie;
    private EditText etReactie;
    private Comment comment = new Comment();
    private ArrayList<Idee> ideeënLijst = IdeeënLijst.getInstance().getIdeeën();
    private Idee idee;
    private ArrayList<Comment> commentList;
    private ListView lv;
    private ReactiesAdapter reactiesAdapter;
    private ImageView backArrow;
    private ListView commentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reageer);

        //idee en ideeënlijst vullen
        idee = ideeënLijst.get(getIntent().getIntExtra(ShowIdeeActivity.EXTRA_IDEE, -1));
        commentList = ideeënLijst.get(getIntent().getIntExtra(ShowIdeeActivity.EXTRA_IDEE, -1)).getComments();

        //kopelen aan views
        btPlaatsReactie = (Button) findViewById(R.id.btPlaats_reactie);
        etReactie = (EditText) findViewById(R.id.et_reageer_text);
        backArrow = (ImageView) findViewById(R.id.iv_reageren_toolbar_backbutton);
        commentListView = (ListView) findViewById(R.id.lvReacties_showIdee);

        //adapter configuratie
        final int ideePositie = getIntent().getIntExtra(ShowIdeeActivity.EXTRA_IDEE, -1);
        reactiesAdapter = new ReactiesAdapter(this, ideePositie);
        commentListView.setAdapter(reactiesAdapter);

        //als de terug knop wordt ingedrukt ga dan naar de vorige activity
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //onclicklisnter voor de post knop
        btPlaatsReactie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //als er nog velden leeg zijn laat dat aan de user zien
                if (TextUtils.isEmpty(etReactie.getText())) {
                    Toast toast = Toast.makeText(getApplicationContext(), "U mag geen lege reactie plaatsen", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                    //maak een comment, vul hem met de velden en voeg hem toe aan een idee
                } else {
                    comment = new Comment(MainActivity.LOGGED_IN_USER.getName(), etReactie.getText().toString(), MainActivity.LOGGED_IN_USER.getTempImage(), MainActivity.LOGGED_IN_USER);
                    commentList.add(comment);
                    reactiesAdapter.notifyDataSetChanged();
                    Toast toast = Toast.makeText(getApplicationContext(), "Uw Reactie is geplaatst", Toast.LENGTH_SHORT);
                    toast.show();
                    etReactie.setText("");
                }
            }
        });
    }
}
