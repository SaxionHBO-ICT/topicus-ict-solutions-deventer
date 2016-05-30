package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;
import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.View.ReactiesAdapter;

public class ShowIdeeActivity extends AppCompatActivity {
    public static final String EXTRA_IDEE = "idee";
    private ListView commentListView;
    private ReactiesAdapter adapter;

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
        Button btReageer = (Button) findViewById(R.id.btReageer_showIdee);

        btReageer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShowIdeeActivity.this, ReageerActivity.class);
                startActivity(intent);
            }
        });
    }
}
