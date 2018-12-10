package com.example.hashi_placesapi;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.hashi_placesapi.model.MyPlaces;

import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity {

    private ArrayList<MyPlaces> myPlaces;
    private PlacesAdapter categoryAdapter;
    private RecyclerView recyclerView;
    private Context context;

    private String category;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        context = PlacesActivity.this;


        myPlaces = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 1, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);



        AppDataBase appDataBase = new AppDataBase(context);
        appDataBase.open();
        categoryAdapter = new PlacesAdapter(context, appDataBase.getAllPlaces());
        recyclerView.setAdapter(categoryAdapter);
        appDataBase.close();

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();  // optional depending on your needs
    }
}
