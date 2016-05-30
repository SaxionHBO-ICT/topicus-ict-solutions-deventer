package nl.vanlaar.bart.topid.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import nl.vanlaar.bart.topid.Activity.MainActivity.MainActivity;
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

    private Idee idee;
    private User user = MainActivity.LOGGED_IN_USER;

    private MainActivity context = new MainActivity(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_idee);


        ivImagePreview = (ImageView) findViewById(R.id.ivImagePreview_makeIdee);

        final EditText etIdeeTitle = (EditText) findViewById(R.id.etIdeeTitle_makeIdee);
        final EditText etIdeeText = (EditText) findViewById(R.id.etIdeeText_makeIdee);
        final EditText etIdeeSamenvattingText = (EditText) findViewById(R.id.etIdeeSamenvattingText_makeIdee);


        btPost = (Button) findViewById(R.id.btPost_makeIdee);

        cbAnoniem = (CheckBox) findViewById(R.id.cbAnoniem_makeIdee);
        cbKlacht = (CheckBox) findViewById(R.id.cbKlacht_makeIdee);
        cbIdee = (CheckBox) findViewById(R.id.cbIdee_makeIdee);


        cbKlacht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbIdee.isChecked()) {
                    cbIdee.setChecked(false);
                }
                cbKlacht.setChecked(true);
            }
        });

        cbIdee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cbKlacht.isChecked()) {
                    cbKlacht.setChecked(false);
                }
                cbIdee.setChecked(true);
            }
        });

        ivImagePreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, IMAGE_REQUEST_CODE);

            }
        });


        btPost.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {



                if (etIdeeSamenvattingText.getText() == null
                        || etIdeeSamenvattingText.getText().toString().isEmpty()) {
                    Toast.makeText(MakeIdeeActivity.this, "Vul alstublieft alle velden in.", Toast.LENGTH_LONG).show();
                    return;
                }

                if (etIdeeText.getText() == null
                        || etIdeeText.getText().toString().isEmpty()) {
                    Toast.makeText(MakeIdeeActivity.this, "Vul alstublieft alle velden in.", Toast.LENGTH_LONG).show();
                    return;
                }

                if (etIdeeTitle.getText() == null
                        || etIdeeTitle.getText().toString().isEmpty()) {
                    Toast.makeText(MakeIdeeActivity.this, "Vul alstublieft alle velden in.", Toast.LENGTH_LONG).show();
                    return;
                }

                idee = new Idee(etIdeeTitle.getText().toString(), etIdeeText.getText().toString(), etIdeeSamenvattingText.getText().toString());


                if (cbKlacht.isChecked()) {
                    idee.setSoortIdee(Idee.KLACHT);
                }
                if (cbIdee.isChecked()) {
                    idee.setSoortIdee(Idee.IDEE);
                }
                if (cbAnoniem.isChecked()) {
                    idee.setAnonymous(true);

                }


                user.addToPostcount();
                ideeën.add(idee);
               // context.getIdeeënAdapter().notifyDataSetChanged();
                finishActivity(MainActivity.IDEE_REQUESTCODE);
                /*
                getIntent().putExtra("Idee_Bundle",idee.toBundle());
                finishActivity(MainActivity.IDEE_REQUESTCODE);
                */

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
}
