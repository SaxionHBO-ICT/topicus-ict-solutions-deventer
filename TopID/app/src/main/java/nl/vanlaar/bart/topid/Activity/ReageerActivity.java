package nl.vanlaar.bart.topid.Activity;

import android.app.Activity;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reageer);
        idee = ideeënLijst.get(getIntent().getIntExtra(ShowIdeeActivity.EXTRA_IDEE,-1));
        commentList = ideeënLijst.get(getIntent().getIntExtra(ShowIdeeActivity.EXTRA_IDEE,-1)).getComments();

        btPlaatsReactie = (Button) findViewById(R.id.btPlaats_reactie);
        etReactie = (EditText) findViewById(R.id.et_reageer_text);
        backArrow = (ImageView) findViewById(R.id.iv_reageren_toolbar_backbutton);

        final int ideePositie = getIntent().getIntExtra(ShowIdeeActivity.EXTRA_IDEE,-1);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });


        btPlaatsReactie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(etReactie.getText())){
                    Toast toast = Toast.makeText(getApplicationContext(),"U mag het textveld niet leeg laten", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                } else {
                    comment = new Comment(MainActivity.LOGGED_IN_USER.getName(),etReactie.getText().toString(),idee,MainActivity.LOGGED_IN_USER.getTempImage(),MainActivity.LOGGED_IN_USER);
                    commentList.add(comment);
                    reactiesAdapter = new ReactiesAdapter(ReageerActivity.this,ideePositie);

                    Toast toast = Toast.makeText(getApplicationContext(),"Uw Reactie is geplaatst", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();

                }



            }
        });
    }

}
