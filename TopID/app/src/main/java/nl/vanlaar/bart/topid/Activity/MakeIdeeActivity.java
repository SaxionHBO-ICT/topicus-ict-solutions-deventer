package nl.vanlaar.bart.topid.Activity;

import android.app.Activity;
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
    private ArrayList<Idee> ideeën = IdeeënLijst.getInstance().getIdeeën();
    private static final int IMAGE_REQUEST_CODE = 1337;
    private ImageView ivImagePreview;
    private Button btPost;
    private CheckBox cbKlacht;
    private CheckBox cbIdee;
    private CheckBox cbAnoniem;
    private Idee idee = new Idee();
    private User user = MainActivity.LOGGED_IN_USER;
    private EditText etIdeeTitle;
    private EditText etIdeeText;
    private EditText etIdeeSamenvattingText;
    private Toolbar toolbar;
    private ImageView backArrow;
    private ImageView menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_idee);

        //set our custom toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //koppelen aan views
        menuButton = (ImageView) findViewById(R.id.iv_make_idee_menu);
        backArrow = (ImageView) findViewById(R.id.iv_iedeeën_toolbar_backbutton);
        ivImagePreview = (ImageView) findViewById(R.id.ivImagePreview_makeIdee);
        etIdeeTitle = (EditText) findViewById(R.id.etIdeeTitle_makeIdee);
        etIdeeText = (EditText) findViewById(R.id.etIdeeText_makeIdee);
        etIdeeSamenvattingText = (EditText) findViewById(R.id.etIdeeSamenvattingText_makeIdee);
        btPost = (Button) findViewById(R.id.btPost_makeIdee);
        cbAnoniem = (CheckBox) findViewById(R.id.cbAnoniem_makeIdee);
        cbKlacht = (CheckBox) findViewById(R.id.cbKlacht_makeIdee);
        cbIdee = (CheckBox) findViewById(R.id.cbIdee_makeIdee);

        //als er op de menu knop gedrukt wordt ga dan naar het menu
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MakeIdeeActivity.this, HomescreenActivity.class);
                startActivity(intent);
            }
        });

        //als er op de back button gedrukt wordt ga dan naar de vorige activity
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });

        //anoniem vinker
        cbAnoniem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbAnoniem.isChecked()) {
                    idee.setAnonymous(true);
                } else {
                    idee.setAnonymous(false);
                }
            }
        });

        //Als klacht is aangevinkt mag idee niet aangevinkt zijn
        cbKlacht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbIdee.isChecked()) {
                    cbIdee.setChecked(false);
                }
                idee.setSoortIdee(Idee.KLACHT);
            }
        });
        //als idee aangevinkt is dan maag klacht niet aangevinkt zijn
        cbIdee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbKlacht.isChecked()) {
                    cbKlacht.setChecked(false);
                }
                idee.setSoortIdee(Idee.IDEE);
            }
        });
        //als de preview image wordt aangedrukt open dan de media store
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
                idee.getTitle();
                return false;
            }
        });

        etIdeeSamenvattingText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }
        });

        etIdeeText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }
        });

        btPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //als niet alles ingevult is toast dat
                if (TextUtils.isEmpty(etIdeeSamenvattingText.getText())
                        || TextUtils.isEmpty(etIdeeText.getText())
                        || TextUtils.isEmpty(etIdeeTitle.getText())) {
                    Toast toast = Toast.makeText(getApplicationContext(), "s.v.p. alle textvelden invullen.", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                } else {
                    //full het idee in met de ingevulde informatie
                    idee.setTitle(etIdeeTitle.getText().toString());
                    idee.setSummaryText(etIdeeSamenvattingText.getText().toString());
                    idee.setMainText(etIdeeText.getText().toString());
                    //als anoniem is aangevinkt maak de user van het idee null anders maak de user de ingelogte user
                    if (cbAnoniem.isChecked()) {
                        idee.setAnoniem(true);
                    } else {
                        idee.setAnoniem(false);
                    }
                    idee.setPoster(MainActivity.LOGGED_IN_USER);
                    MainActivity.LOGGED_IN_USER.addToPostcount();
                    //voeg het idee toe
                    IdeeënLijst.getInstance().addIdee(idee);

                    //notify de user dat zijn idee is geplaatst
                    Toast toast = Toast.makeText(getApplicationContext(), "Uw Idee/Klacht is geplaatst", Toast.LENGTH_SHORT);
                    toast.show();

                    Intent intent = new Intent(MakeIdeeActivity.this, MainActivity.class);
                    //start de main activity weer op. zodat die overnieuw door de oncreate heen gaat.
                    startActivity(intent);
                    //sluit de make idee activity af zodat deze van de stack verdwijnt.
                    finish();
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    }

    /**
     * Past het aangewezen plaatje aan zodat het de aplicatie niet lagt
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                if (bitmap.getHeight() > 3840 && bitmap.getWidth() > 2160) {
                    bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getHeight() / 4, bitmap.getWidth() / 4, false);
                } else if (bitmap.getHeight() > 2500 && bitmap.getWidth() > 1500) {
                    bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getHeight() / 3, bitmap.getWidth() / 3, false);
                } else if (bitmap.getHeight() > 1920 && bitmap.getWidth() > 1080) {
                    bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getHeight() / 2, bitmap.getWidth() / 2, false);
                }
                ivImagePreview.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
