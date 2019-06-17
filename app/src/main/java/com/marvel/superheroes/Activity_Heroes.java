package com.marvel.superheroes;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.marvel.superheroes.Constans.Constantes;
import com.marvel.superheroes.adapters.AdapterHeroes;

public class Activity_Heroes extends Activity {
    RecyclerView recyclerView;
    private AdapterHeroes adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_heroes);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(Activity_Heroes.this, 2));
        adapter = new AdapterHeroes(Constantes.name, Activity_Heroes.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

}
