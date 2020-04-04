package com.siti.sitiuts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.siti.sitiuts.adapters.PesanAdapter;
import com.siti.sitiuts.models.Account;
import com.siti.sitiuts.models.Order;

public class PesanActivity extends AppCompatActivity implements PesanAdapter.OnItemPesanListener{

    public static final String PESAN_KEY = "PESAN";
    public static final String INDEX_KEY = "INDEX";
    public static final int INSERT_REQUEST = 1;
    public static final int UPDATE_REQUEST = 2;

    private TextView welcomeText;
    private TextView balanceText;
    private RecyclerView PesanView;
    private PesanAdapter adapter;
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesan);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        welcomeText = findViewById(R.id.text_welcome);
        balanceText = findViewById(R.id.text_balance);
        PesanView = findViewById(R.id.rv_pesan);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PesanActivity.this, TambahPesanActivity.class);
                intent.putExtra(PESAN_KEY, new Order());
                startActivityForResult(intent, INSERT_REQUEST);
                // TODO: Tambahkan event click fab di sini
            }
        });
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int index = viewHolder.getAdapterPosition();
                adapter.notifyDataSetChanged();
            }
        };
        new ItemTouchHelper(simpleItemTouchCallback).attachToRecyclerView(PesanView);

        welcomeText.setText(String.format("Selamat Datang di KopiKuy"));
        balanceText.setText(String.format("Silahkan Klik PESAN KOPI Untuk Proses Pemesanan"));

        adapter = new PesanAdapter(account.getOrders(), this);
        PesanView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        PesanView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pesan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPesanClicked(int index, Order item) {
        Intent intent = new Intent(this, TambahPesanActivity.class);
        intent.putExtra(PESAN_KEY, item);
        intent.putExtra(INDEX_KEY, 0);
        startActivityForResult(intent, UPDATE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Order order = data.getParcelableExtra(PESAN_KEY);
            if (requestCode == INSERT_REQUEST) {
                account.addOrder(order);
            }
            else if (requestCode == UPDATE_REQUEST) {
                int index = data.getIntExtra(INDEX_KEY, 0);
                account.updateOrder(index, order);
            }
            adapter.notifyDataSetChanged();
        }
    }


    public static class SettingsFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);
        }
    }
}
