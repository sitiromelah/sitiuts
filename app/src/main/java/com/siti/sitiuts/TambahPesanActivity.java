package com.siti.sitiuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.siti.sitiuts.models.Order;

public class TambahPesanActivity extends AppCompatActivity {

    private EditText NamaInput;
    private EditText NomorInput;
    private EditText PesanInput;
    private EditText JumlahInput;
    private Button btnBatal;
    private Order item;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pesan);

        NamaInput = findViewById(R.id.txtNama);
        NomorInput = findViewById(R.id.txtNomor);
        PesanInput = findViewById(R.id.txtPesan);
        JumlahInput = findViewById(R.id.txtJumlah);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            item = extras.getParcelable(PesanActivity.PESAN_KEY);
            index = extras.getInt(PesanActivity.INDEX_KEY, 0);
            NamaInput.setText(item.getNama());
            NomorInput.setText(item.getNomor());
            PesanInput.setText(item.getPesan());
            JumlahInput.setText(item.getJumlah());
        }
    }

    public void handleSimpan(View view) {
        String nama = NamaInput.getText().toString();
        String nomor = NomorInput.getText().toString();
        String pesan = PesanInput.getText().toString();
        String jumlah = JumlahInput.getText().toString();

        item.setNama(nama);
        item.setNomor(nomor);
        item.setPesan(pesan);
        item.setJumlah(jumlah);

        if (nama.equals("") && nomor.equals("") && pesan.equals("") && jumlah.equals("")) {
            Toast.makeText(getApplicationContext(), "Input yang anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        } else if (nama.equals("")) {
            Toast.makeText(getApplicationContext(), "Input nama anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        } else if (nomor.equals("")) {
            Toast.makeText(getApplicationContext(), "Input nomor anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        } else if (pesan.equals("")) {
            Toast.makeText(getApplicationContext(), "Input pesan anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        } else if (jumlah.equals("")) {
            Toast.makeText(getApplicationContext(), "Input jumlah anda masukan kosong",
                    Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra(PesanActivity.PESAN_KEY, item);
            intent.putExtra(PesanActivity.INDEX_KEY, index);
            setResult(RESULT_OK, intent);
            finish();
            this.btnBatal.setText("Kembali");
        }
    }

    public void handleHapus(View view) {
    }

    public void handleBatal(View view) {
    }
}
