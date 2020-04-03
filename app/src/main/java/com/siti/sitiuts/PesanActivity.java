package com.siti.sitiuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.siti.sitiuts.adapters.PesanAdapter;
import com.siti.sitiuts.models.Pesan;

public class PesanActivity extends AppCompatActivity
        implements PesanAdapter.OnItemPesanListener{

    public static final String PESAN_KEY = "PESAN";
    public static final String INDEX_KEY = "INDEX";
    public static final int INSERT_REQUEST = 1;
    public static final int UPDATE_REQUEST = 2;

    private TextView welcomeText;
    private RecyclerView transactionsView;
    private PesanAdapter adapter;
    @Override
    public void onPesanClicked(int index, Pesan item) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
