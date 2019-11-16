package com.moviles.starwars_recyclerview;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Providers.ReadInformation;
import model.Film;

public class MainActivity extends AppCompatActivity {

    private RecyclerView filmRecyclerView;
    private RecyclerView.Adapter myFilmAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Film> filmList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmRecyclerView = findViewById(R.id.filmRecyclerView);

        filmList = new ArrayList<>();
        fillDataSetOfBands ();


        layoutManager = new LinearLayoutManager(this);
        filmRecyclerView.setLayoutManager(layoutManager);

        myFilmAdapter = new FilmAdapter(filmList);
        filmRecyclerView.setAdapter(myFilmAdapter);
    }

    public void fillDataSetOfBands () {

        ReadInformation readerOfInfo = new ReadInformation();
        filmList = readerOfInfo.getAllFilms();
        while(filmList.size()!=7){

        }
    }

}
