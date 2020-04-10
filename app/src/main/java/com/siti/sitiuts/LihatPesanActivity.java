package com.siti.sitiuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.siti.sitiuts.entities.Pesan;
import com.siti.sitiuts.models.PesanModel;

import java.util.ArrayList;

public class LihatPesanActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //Data
    private PesanModel mKontak;
    private ArrayList<Pesan> allPesan;
    private ArrayList<String> daftarNama;

    //Komponen
    private ListView lstDaftatKontak;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_pesan);

        this.initData();
        this.initComponents();
    }

    @Override
    protected void onStart(){
        super.onStart();

        this.initData();

        this.initComponents();
    }

    private void initData()
    {
        this.daftarNama = new ArrayList<>();

        this.mKontak = new PesanModel(this);

        this.allPesan = this.mKontak.selectAll();

        for(Pesan k : allPesan)
        {
            this.daftarNama.add(k.getNama());
        }
    }

    private void initComponents()
    {
        this.lstDaftatKontak = (ListView)this.findViewById(R.id.lstDaftarKontak);
        this.btnOk = (Button)this.findViewById(R.id.btnOk);

        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, this.daftarNama);

        this.lstDaftatKontak.setAdapter(adapter);

        this.lstDaftatKontak.setOnItemClickListener(this);
    }
    public void button_onClick(View view){
        Button b = (Button) view;

        if(b == this.btnOk)
            this.finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        int id = this.allPesan.get(i).getId();
        Intent intent = new Intent(this, DetailPesanActivity.class);
        intent.putExtra("selectedContactId", id);
        this.startActivity(intent);

    }
}
