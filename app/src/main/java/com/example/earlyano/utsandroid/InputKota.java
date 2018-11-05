package com.example.earlyano.utsandroid;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputKota extends AppCompatActivity {
    private AppDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_kota);

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"kotadb").build();

        final EditText namaKota = findViewById(R.id.editText3);
        final Button btSubmit = findViewById(R.id.button2);
        final Button btCek = findViewById(R.id.cekKota);

        final Kota kota = (Kota) getIntent().getSerializableExtra("data");

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kota k = new Kota();
                k.setNamaKota(namaKota.getText().toString());
                insertData(k);
            }
        });

        btCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Read_data.getActIntent(InputKota.this));
            }
        });
    }

    private void insertData(final Kota kota){
        new AsyncTask<Void, Void, Long>(){

            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.kotaDAO().insertKota(kota);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(InputKota.this,"Insert Sukses",Toast.LENGTH_SHORT).show();
            }
        }.execute();

//        finish();
    }

//    private void gotoactivity(){
//        Intent mIntent = new Intent(getApplicationContext(), Read_data.class);
//        startActivity(mIntent);
//    }
}
