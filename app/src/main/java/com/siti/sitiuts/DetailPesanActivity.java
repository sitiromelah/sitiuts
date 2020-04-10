package com.siti.sitiuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.siti.sitiuts.entities.Pesan;
import com.siti.sitiuts.models.PesanModel;

public class DetailPesanActivity extends AppCompatActivity {

    // Data
    private PesanModel mKontak;
    private Pesan selectedKontak;
    // Komponen
    private EditText txtNama;
    private EditText txtNomor;
    private EditText txtPesan;
    private EditText txtJumlah;
    private Button btnUbah;
    private Button btnKembali;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesan);
        this.initData();
        this.initComponents();
    }
    private void initData()
    {
        this.mKontak = new PesanModel(this);
        int selectedContactId = this.getIntent().getIntExtra("selectedContactId", -1);
        this.selectedKontak = this.mKontak.selectOne(selectedContactId);
    }
    private void initComponents()
    {
        this.txtNama = (EditText) this.findViewById(R.id.txtNama);
        this.txtNomor = (EditText) this.findViewById(R.id.txtNomor);
        this.txtPesan = (EditText) this.findViewById(R.id.txtPesan);
        this.txtJumlah = (EditText) this.findViewById(R.id.txtJumlah);
        this.btnUbah = (Button) this.findViewById(R.id.btnUbah);
        this.btnKembali = (Button) this.findViewById(R.id.btnKembali);

        //Isi teks komonen saat Activity baru muncul
        this.txtNama.setText(this.selectedKontak.getNama());
        this.txtNomor.setText(this.selectedKontak.getNomor());
        this.txtPesan.setText(this.selectedKontak.getPesan());
        this.txtJumlah.setText(this.selectedKontak.getJumlah());
    }
    public void button_onClick(View view)
    {
        Button b = (Button) view;
        if(b == this.btnUbah)
        {
            this.ubahKontak();
        }
        else if(b == this.btnKembali)
        {
            this.finish();
        }
    }
    private void ubahKontak()
    {
        String nama = this.txtNama.getText().toString();
        String nomor =  this.txtNomor.getText().toString();
        String pesan = this.txtPesan.getText().toString();
        String jumlah =  this.txtJumlah.getText().toString();

        this.selectedKontak.setNama(nama);
        this.selectedKontak.setNomor(nomor);
        this.selectedKontak.setPesan(pesan);
        this.selectedKontak.setJumlah(jumlah);
        this.mKontak.update(this.selectedKontak);

        this.resetFields("Data berhasil diperbarui",false);

        Intent i = new Intent(this, LihatPesanActivity.class);
        this.startActivity(i);
    }

    private void resetFields(String pesan, boolean clear) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show();

        if(clear)
        {
            this.txtNama.setText("");
            this.txtNomor.setText("");
            this.txtPesan.setText("");
            this.txtJumlah.setText("");
        }
    }

}
