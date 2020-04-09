package com.siti.sitiuts;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.siti.sitiuts.entities.Pesan;
import com.siti.sitiuts.models.PesanModel;

public class TambahPesanActivity extends AppCompatActivity {

    //Data
    private PesanModel mKontak;
    // Komponen
    private EditText txtNama;
    private EditText txtNomor;
    private EditText txtPesan;
    private EditText txtJumlah;
    private Button btnSimpan;
    private Button btnBatal;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pesan);
        this.initData();
        this.initComponents();
    }
    private void initData()
    {
        this.mKontak = new PesanModel(this);
    }
    private void initComponents()
    {
        this.txtNama = (EditText) this.findViewById(R.id.txtNama);
        this.txtNomor = (EditText) this.findViewById(R.id.txtNomor);
        this.txtPesan = (EditText) this.findViewById(R.id.txtPesan);
        this.txtJumlah = (EditText) this.findViewById(R.id.txtJumlah);
        this.btnSimpan = (Button) this.findViewById(R.id.btnSimpan);
        this.btnBatal = (Button) this.findViewById(R.id.btnBatal);
    }
    public void button_onClick(View view) {
        Button b = (Button) view;
        if(b == this.btnSimpan) {
            this.tambahKontak();
        }

        //if (txtNama.getText().toString().length() == 0) {
        //txtNama.setError("Isi Nama Terlebih dahulu!");

        //} if(txtNomor.getText().toString().length() == 0) {
        //txtNomor.setError("Isi Nomor Terlebih dahulu");

        //} else if (b == this.btnSimpan){
        //this.tambahKontak();
        //}

        if (b == btnBatal){
            this.finish();
        }
    }
    private void tambahKontak()
    {

        String nama = this.txtNama.getText().toString();
        String nomor = this.txtNomor.getText().toString();
        String pesan = this.txtPesan.getText().toString();
        String jumlah = this.txtJumlah.getText().toString();

        Pesan kontakBaru = new Pesan();
        kontakBaru.setNama(nama);
        kontakBaru.setNomor(nomor);
        kontakBaru.setPesan(pesan);
        kontakBaru.setJumlah(jumlah);

        //this.mKontak.insert(kontakBaru);

        //Toast.makeText(this, "Kontak Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();

        //this.btnBatal.setText("Kembali");

        if(nama.equals("") && nomor.equals("") && pesan.equals("") && jumlah.equals("")){
            Toast.makeText(getApplicationContext(), "Input yang anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        }
        else if(nama.equals("")){
            Toast.makeText(getApplicationContext(), "Input nama anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        }
        else if(nomor.equals("")) {
            Toast.makeText(getApplicationContext(), "Input nomor anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        }else if(pesan.equals("")){
            Toast.makeText(getApplicationContext(), "Input pesan anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        }
        else if(jumlah.equals("")) {
            Toast.makeText(getApplicationContext(), "Input jumlah anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        }

        else{
            this.mKontak.insert(kontakBaru);

            Toast.makeText(this, "Kontak Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();

            this.btnBatal.setText("Kembali");
        }
    }
}
