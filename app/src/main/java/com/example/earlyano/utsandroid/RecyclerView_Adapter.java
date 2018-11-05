package com.example.earlyano.utsandroid;

//import android.arch.persistence.room.Room;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.ViewHolder> {
    private ArrayList<Kota> daftarKota;
    private Context context;
    private AppDatabase db;

    public RecyclerView_Adapter(ArrayList<Kota> kota, Context ctx) {
        daftarKota = kota;
        context = ctx;

        db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "kotadb").allowMainThreadQueries().build();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //ViewHolder vh = new ViewHolder(v);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.kota_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView_Adapter.ViewHolder viewHolder, int i) {
        final String name = daftarKota.get(i).getNamaKota();
        viewHolder.txtNama.setText(name);
        //viewHolder.txtKota.setText(name);
    }

    @Override
    public int getItemCount() {
        return daftarKota.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNama;
        public ViewHolder(View itemView){
            super(itemView);
            txtNama = itemView.findViewById(R.id.textView);
        }
    }
}
