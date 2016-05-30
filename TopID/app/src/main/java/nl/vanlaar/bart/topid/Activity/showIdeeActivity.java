package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import nl.vanlaar.bart.topid.R;
import nl.vanlaar.bart.topid.ReageerActivity;

public class showIdeeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_idee);

        Button btReageer = (Button) findViewById(R.id.btReageer_showIdee);

        btReageer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(showIdeeActivity.this, ReageerActivity.class);
                startActivity(intent);
            }
        });
    }
}
