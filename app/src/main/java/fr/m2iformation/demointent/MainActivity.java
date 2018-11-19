package fr.m2iformation.demointent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etDomain;
    TextView tvLogin;
    ImageView ivPhoto;
    final int REQUEST_CODE_LOGIN = 1;
    final int REQUEST_CODE_PHOTO = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etDomain = findViewById(R.id.etDomain);
        tvLogin = findViewById(R.id.tvLogin);
        ivPhoto = findViewById(R.id.ivPhoto);
    }

    @Override
    protected void onResume() {
        super.onResume();
        etDomain = findViewById(R.id.etDomain);
        tvLogin = findViewById(R.id.tvLogin);
        ivPhoto = findViewById(R.id.ivPhoto);
    }

    // ============ Start Activity ===============
    public void btnDemo1(View view) {
        Intent i = new Intent(this, activity_login.class);
        i.putExtra("domaine", etDomain.getText().toString());
        startActivity(i);
    }

    // ======== Start Activity for Result ==========
    public void btnDemo2(View view) {
        Intent i = new Intent(this, activity_login.class);
        i.putExtra("domaine", etDomain.getText().toString());
        startActivityForResult(i, REQUEST_CODE_LOGIN);
    }

    // ============= On Activity Result =================
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_LOGIN) {
            if (resultCode == RESULT_OK) {
                String log = data.getStringExtra("login");
                tvLogin.setText(log);
            } else {
                String log = "Non connecté";
                tvLogin.setText(log);
            }
        }  if (requestCode == REQUEST_CODE_PHOTO) {
            if (resultCode == RESULT_OK) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                ivPhoto.setImageBitmap(bitmap);
            }
        }
    }


    public void btnDemo3(View view) {
        Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, REQUEST_CODE_PHOTO);

    }
}
