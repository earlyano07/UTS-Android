package com.example.earlyano.utsandroid;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tbarang")
public class Kota implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int kotaId;

    @ColumnInfo(name = "nama_kota")
    public String namaKota;

    public void setKotaId(int kotaId) {
        this.kotaId = kotaId;
    }

    public void setNamaKota(String namaKota) {
        this.namaKota = namaKota;
    }

    public int getKotaId() {
        return kotaId;
    }

    public String getNamaKota() {
        return namaKota;
    }
}
