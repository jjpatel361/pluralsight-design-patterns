package com.designpatterns.bridge;

public class Music {

    private String artist;
    private String label;
    private String releaseDate;

    public Music(String artist, String label, String releaseDate) {
        this.artist = artist;
        this.label = label;
        this.releaseDate = releaseDate;
    }

    public String getArtist() {
        return artist;
    }

    public String getLabel() {
        return label;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
