package com.siti.sitiuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.siti.sitiuts.adapters.MenuAdapter;
import com.siti.sitiuts.models.MenuLogo;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    private Button btnPesan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        RecyclerView menusView = findViewById(R.id.rv_menus);

        List<MenuLogo> menus = new ArrayList<>();
        menus.add(new MenuLogo("https://upload.wikimedia.org/wikipedia/en/thumb/0/0c/Liverpool_FC.svg/360px-Liverpool_FC.svg.png", "Americano"));
        menus.add(new MenuLogo("https://id.pinterest.com/pin/125819383309141902/?nic_v1=1aeDpwwqmQYqS5XX1U8Ox05J6hnZd3DQEFifEH9zdsNnyBYqDJn1ipEbSdF1tRL0LT", "Cappuccino"));
        menus.add(new MenuLogo("https://id.pinterest.com/pin/574631233677348199/?nic_v1=1aDfveAmJK3P1DY7I7nyl7bTf5cS676fi7zrMFD1RI79BX0LLsH7%2FVhop2pqzsULJ7", "Doppio"));
        menus.add(new MenuLogo("https://id.pinterest.com/pin/569775790340125033/?nic_v1=1akMTcHl%2BQQ75sS%2BO5TaOLqDHLhBqV1eAWRi%2FurI54DR%2FTkx0YRyIxo02KdqQC08jB", "Lungo"));
        menus.add(new MenuLogo("https://id.pinterest.com/pin/87820261457571005/?nic_v1=1a%2BsBHnZ7MRP28Mh6CYV5LZuNBXSti4dsuS7esPkhvc84QmLrhIRwU6M5uE6VcE0bK", "Coffee"));

        MenuAdapter adapter = new MenuAdapter(this, menus);
        menusView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        menusView.setLayoutManager(layoutManager);
        btnPesan = findViewById(R.id.btnPesan);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PesanActivity.class);
                startActivity(i);
            }
        });
    }
}
