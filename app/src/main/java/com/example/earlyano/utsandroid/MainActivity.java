package com.example.earlyano.utsandroid;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUserName, edtPassword;
    Button btnLogin;
    SessionManagement sessionManagement;
    AlertDialogManager alert = new AlertDialogManager();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUserName = findViewById(R.id.editText);
        edtPassword = findViewById(R.id.editText2);
        btnLogin = findViewById(R.id.button);
        sessionManagement = new SessionManagement(getApplicationContext());
        Toast.makeText(getApplicationContext(), "User Login Status: " + sessionManagement.isLoggedIn(), Toast.LENGTH_LONG).show();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();

                if (username.trim().length() > 0 && password.trim().length() > 0) {
                    sessionManagement.createLoginSession(edtUserName.getText().toString(), edtPassword.getText().toString());
                    Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                    startActivity(i);
                    finish();
                } else {
                    alert.showAlertDialog(MainActivity.this, "Login failed..", "Masukkan Username dan Password anda!", false);
                }

            }

        });
    }
}


