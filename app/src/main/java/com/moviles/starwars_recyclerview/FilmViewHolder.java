package com.moviles.starwars_recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class FilmViewHolder extends RecyclerView.ViewHolder{

    public TextView title;
    public TextView episode;
    public TextView opening_crawl;
    public TextView director;


    public FilmViewHolder(View bandView) {
        super(bandView);

        this.title = (TextView) itemView.findViewById(R.id.filmTitle);;
        this.episode = (TextView) itemView.findViewById(R.id.filmEpisode);
        this.opening_crawl = (TextView) itemView.findViewById(R.id.filmOpeningCrawl);
        this.director = (TextView) itemView.findViewById(R.id.filmDirector);
    }


}
