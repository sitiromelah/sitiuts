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
        menus.add(new MenuLogo("https://upload.wikimedia.org/wikipedia/commons/1/19/Affogato.JPG", "Affogato"));
        menus.add(new MenuLogo("https://upload.wikimedia.org/wikipedia/commons/b/b4/Americano.jpg", "Americano"));
        menus.add(new MenuLogo("https://upload.wikimedia.org/wikipedia/commons/1/16/Classic_Cappuccino.jpg", "Cappuccino"));
        menus.add(new MenuLogo("https://upload.wikimedia.org/wikipedia/commons/4/41/Espresso_BW_1.jpg", "Espresso"));
        menus.add(new MenuLogo("https://upload.wikimedia.org/wikipedia/commons/9/92/Echo_Coffee_-_Latte.jpg", "Latte"));
        menus.add(new MenuLogo("https://upload.wikimedia.org/wikipedia/commons/2/2b/Lungo_coffee.jpg", "Lungo"));
        menus.add(new MenuLogo("https://upload.wikimedia.org/wikipedia/commons/a/ab/Macchiato_BlueBottle_1.jpg", "Macchiato"));
        menus.add(new MenuLogo("https://upload.wikimedia.org/wikipedia/commons/8/8c/Coffee_Latte.jpg", "Ristretto"));

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
