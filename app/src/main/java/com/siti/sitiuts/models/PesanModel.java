package com.siti.sitiuts.models;

import android.content.Context;
import android.database.Cursor;

import com.siti.sitiuts.entities.Pesan;
import com.siti.sitiuts.libraries.DbHelper;

import java.util.ArrayList;

public class PesanModel {
    private Context context;
    private DbHelper db;

    public PesanModel(Context context)
    {
        this.context = context;

        this.db = new DbHelper(this.context);
    }

    public ArrayList<Pesan> selectAll()
    {
        String sql = "SELECT * FROM pesan";

        ArrayList<Pesan> semuaPesan = new ArrayList<>();

        Cursor cursor = this.db.executeRead(sql);

        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();

            do {
                int id = cursor.getInt(0);
                String nama = cursor.getString(1);
                String nomor = cursor.getString(2);
                String pesan = cursor.getString(3);
                String jumlah = cursor.getString(4);

                Pesan k = new Pesan();

                k.setId(id);
                k.setNama(nama);
                k.setNomor(nomor);
                k.setPesan(pesan);
                k.setJumlah(jumlah);

                semuaPesan.add(k);
            }
            while(cursor.moveToNext());
        }
        return semuaPesan;
    }

    public void insert(Pesan k)
    {
        String nama = k.getNama();
        String nomor = k.getNomor();
        String pesan = k.getPesan();
        String jumlah = k.getJumlah();

        String sql = "INSERT INTO pesan(nama, nomor, pesan, jumlah) VALUES('"+nama+"','"+nomor+"','"+pesan+"','"+jumlah+"')";

        this.db.executeWrite(sql);
    }

    public void update(Pesan k)
    {
        if(k.getId() < 0)
            return;
        int id = k.getId();
        String nama = k.getNama();
        String nomor = k.getNomor();
        String pesan = k.getPesan();
        String jumlah = k.getJumlah();
        String sql = "UPDATE pesan SET nama = '" + nama + "', nomor = '" + nomor + "', pesan = '" + pesan + "', jumlah = '" + jumlah + "' WHERE id = '" + id + "'";
        this.db.executeWrite(sql);
    }

    public Pesan selectOne(int id)
    {
        String sql = "SELECT * FROM pesan WHERE id = '" + id + "'";
        Cursor cursor = this.db.executeRead(sql);
        if(cursor.getCount() > 0)
        {
            cursor.moveToFirst();
            Pesan k = new Pesan();
            k.setId(cursor.getInt(0));
            k.setNama(cursor.getString(1));
            k.setNomor(cursor.getString(2));
            k.setPesan(cursor.getString(3));
            k.setJumlah(cursor.getString(4));
            return k;
        }
        return null;
    }

    public void delete(Pesan k)
    {
        if(k.getId()<0)
            return;

        String sql = "DELETE FROM pesan WHERE id = '" + k.getId() + "'";

        this.db.executeWrite(sql);
    }
}
