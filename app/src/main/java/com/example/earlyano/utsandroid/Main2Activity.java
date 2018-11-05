package com.example.earlyano.utsandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    Button btn;
    TextView txtView;
    SessionManagement sessionManagement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn = findViewById(R.id.buttonLogout);
        txtView = findViewById(R.id.tvEmail);
        sessionManagement = new SessionManagement(getApplicationContext());

        HashMap<String, String> user =  sessionManagement.getUserInformation();
        String name = user.get(sessionManagement.KEY_USERNAME);

        // session.toString();
        txtView.setText(name);

        //txtView.addTextChangedListener((TextWatcher) session);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sessionManagement.logoutUser();
                Intent i = new Intent(getApplicationContext(), InputKota.class);
                startActivity(i);
            }
        });

    }
}