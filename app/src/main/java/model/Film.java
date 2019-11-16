package model;

public class Film {

    private String title;
    private String episode;
    private String opening_crawl;
    private String director;

    public Film(){
    }

    public Film(String title, String episode, String opening_crawl, String director) {
        this.title = title;
        this.episode = episode;
        this.opening_crawl = opening_crawl;
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
