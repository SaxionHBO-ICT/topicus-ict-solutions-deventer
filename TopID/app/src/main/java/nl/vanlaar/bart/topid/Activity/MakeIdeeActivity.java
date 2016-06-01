package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import nl.vanlaar.bart.topid.Model.Idee;
import nl.vanlaar.bart.topid.Model.IdeeënLijst;
import nl.vanlaar.bart.topid.Model.User;
import nl.vanlaar.bart.topid.R;

public class MakeIdeeActivity extends AppCompatActivity {
    private ArrayList<Idee> ideeën = IdeeënLijst.getIdeeënLijst();
    private static final int IMAGE_REQUEST_CODE = 1337;

    private ImageView ivImagePreview;
    private Button btPost;
    private CheckBox cbKlacht;
    private CheckBox cbIdee;
    private CheckBox cbAnoniem;

    private Idee idee = new Idee();
    private User user = MainActivity.LOGGED_IN_USER;

    private MainActivity context = new MainActivity(this);

    private EditText etIdeeTitle;
    private EditText etIdeeText;
    private EditText etIdeeSamenvattingText;
    private Toolbar toolbar;
    private ImageView backArrow;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_idee);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        backArrow = (ImageView) findViewById(R.id.iv_iedeeën_toolbar_backbutton);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ivImagePreview = (ImageView) findViewById(R.id.ivImagePreview_makeIdee);

        etIdeeTitle = (EditText) findViewById(R.id.etIdeeTitle_makeIdee);
        etIdeeText = (EditText) findViewById(R.id.etIdeeText_makeIdee);
        etIdeeSamenvattingText = (EditText) findViewById(R.id.etIdeeSamenvattingText_makeIdee);


        btPost = (Button) findViewById(R.id.btPost_makeIdee);

        cbAnoniem = (CheckBox) findViewById(R.id.cbAnoniem_makeIdee);
        cbKlacht = (CheckBox) findViewById(R.id.cbKlacht_makeIdee);
        cbIdee = (CheckBox) findViewById(R.id.cbIdee_makeIdee);

        cbAnoniem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cbAnoniem.isChecked()){
                    idee.setAnonymous(true);
                } else {
                    idee.setAnonymous(false);
                }
            }
        });
        cbKlacht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbIdee.isChecked()) {
                    cbIdee.setChecked(false);
                }
                idee.setSoortIdee(Idee.KLACHT);
            }
        });

        cbIdee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbKlacht.isChecked()) {
                    cbKlacht.setChecked(false);
                    idee.setSoortIdee(Idee.IDEE);
                }
            }
        });

        ivImagePreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMAGE_REQUEST_CODE);

            }
        });

        etIdeeTitle.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                idee.setTitle(v.getText().toString());

                return false;
            }
        });

        etIdeeSamenvattingText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                idee.setSummaryText(v.getText().toString());
                return false;
            }
        });

        etIdeeText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                idee.setMainText(v.getText().toString());
                return false;
            }
        });


        btPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(etIdeeSamenvattingText.getText())
                        || TextUtils.isEmpty(etIdeeText.getText())
                        || TextUtils.isEmpty(etIdeeTitle.getText())){
                    Toast toast = Toast.makeText(getApplicationContext(),"s.v.p. alle textvelden invullen.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(),"Uw Idee/Klacht is geplaatst", Toast.LENGTH_SHORT);
                    toast.show();
                    Log.d("idee size voor" ,"" + ideeën.size());
                    ideeën.add(idee);
                    Log.d("idee size na" ,"" + ideeën.size());
                    MainActivity.notifyAdapter();
                    finish();

                }


                //setResult(RESULT_OK);
                // finishActivity(MainActivity.IDEE_REQUESTCODE);

            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                ivImagePreview.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
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
            Intent intent = new Intent(MakeIdeeActivity.this, HomescreenActivity.class);
            startActivity(intent);
        }
        if (id == R.id.topbar_inbox){
            Intent intent = new Intent(MakeIdeeActivity.this, InboxActivity.class);
            startActivity(intent);
        }
        if (id == R.id.topbar_uitloggen){
            Intent intent = new Intent(MakeIdeeActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if (id == R.id.topbar_instellingen){
            Intent intent = new Intent(MakeIdeeActivity.this, InstellingenActivity.class);
            startActivity(intent);
        }
        if (id == R.id.topbar_ideeën){
            Intent intent = new Intent(MakeIdeeActivity.this, MainActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}
