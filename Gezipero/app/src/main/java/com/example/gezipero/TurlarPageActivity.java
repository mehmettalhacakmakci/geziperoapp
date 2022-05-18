package com.example.gezipero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class TurlarPageActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private String search;
    private Toolbar toolbar;
    private RecyclerView rv;
    private ArrayList<Turlar> kelimelerListe;
    private TurlarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turlar_page);

        search = (String) getIntent().getSerializableExtra("arama");

        toolbar = findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);

        toolbar.setTitle(search);

        setSupportActionBar(toolbar);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        kelimelerListe = new ArrayList<>();

        Turlar k1 = new Turlar(1,"Kapadokya Turu","400 TL");
        Turlar k2 = new Turlar(2,"Gap Turu","1750 TL");
        Turlar k3 = new Turlar(3,"Adalar Turu","1250 TL");

        kelimelerListe.add(k1);
        kelimelerListe.add(k2);
        kelimelerListe.add(k3);



        adapter = new TurlarAdapter(this,kelimelerListe);

        rv.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbarmenu,menu);

        MenuItem item = menu.findItem(R.id.action_back);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("gönderilen arama",query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("harf girdikce arama",newText);

        return false;
    }


}