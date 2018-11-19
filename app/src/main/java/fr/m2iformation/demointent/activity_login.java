package fr.m2iformation.demointent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_login extends AppCompatActivity {

    EditText etDomain;
    EditText etLogin;
    EditText etPwd;
    Button btOk;
    Button btCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etDomain = findViewById(R.id.etDomain);
        etLogin = findViewById(R.id.etLogin);
        etPwd = findViewById(R.id.etPwd);
        btOk = findViewById(R.id.btOk);
        btCancel = findViewById(R.id.btCancel);

        Intent i = getIntent();
        etDomain.setText(i.getStringExtra("domaine"));
    }

    public void btOk(View view) {
        Intent i = new Intent(this, MainActivity.class);
        if (etLogin.getText().toString().equals(etPwd.getText().toString()) ) {
            setResult(RESULT_OK,i);
            i.putExtra("login", etLogin.getText().toString());
        } else {
            setResult(RESULT_CANCELED,i);
        }
        finish();
    }

    public void btCancel(View view) {
        Intent i = new Intent(this, MainActivity.class);
        setResult(RESULT_CANCELED,i);
        finish();
    }


    public void SMS(View view) {
        Uri uri = Uri.parse("smsto:062211544587");
        Intent it = new Intent(Intent.ACTION_SENDTO, uri);
        it.putExtra("sms_body", "The SMS text");
        startActivity(it);

    }
}

