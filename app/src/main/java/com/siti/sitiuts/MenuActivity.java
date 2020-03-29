package com.siti.sitiuts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.siti.sitiuts.adapters.MenuAdapter;
import com.siti.sitiuts.models.Menu;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        RecyclerView menusView = findViewById(R.id.rv_teams);

        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("", ""));
        menus.add(new Menu("", ""));

        MenuAdapter adapter = new MenuAdapter(this, menus);
        menusView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        menusView.setLayoutManager(layoutManager);
    }
}
