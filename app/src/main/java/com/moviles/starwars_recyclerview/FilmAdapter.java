package com.moviles.starwars_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.Film;

public class FilmAdapter extends RecyclerView.Adapter <FilmViewHolder> {

    private ArrayList<Film> filmList;

    /**
     * Constructor of the adapter class
     * @param filmList
     */
    public FilmAdapter(ArrayList<Film> filmList) {
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.activity_episodes_custom, viewGroup, false);

        FilmViewHolder filmViewHolder = new FilmViewHolder(contactView);

        return filmViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder viewHolder, int i) {

        Film filmTmp = filmList.get(i);

        TextView titleTv = viewHolder.title;
        titleTv.setText(filmTmp.getTitle());

        TextView episodeTv = viewHolder.episode;
        episodeTv.setText(filmTmp.getEpisode());

        TextView directorTv = viewHolder.director;
        directorTv.setText(filmTmp.getDirector());

        TextView openingCrawlTv = viewHolder.opening_crawl;
        openingCrawlTv.setText(filmTmp.getOpening_crawl());

    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }
}
