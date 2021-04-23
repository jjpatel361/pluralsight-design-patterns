package com.designpatterns.bridge;

import java.util.ArrayList;
import java.util.List;

public class MusicPrinter extends Printer {

    private Music music;

    public MusicPrinter(Music m) {
        this.music = m;
    }

    @Override
    protected List<Detail> getDetails() {
        List<Detail> details = new ArrayList<>();
        details.add(new Detail("Artist", music.getArtist()));
        details.add(new Detail("Release Date", music.getReleaseDate()));
        details.add(new Detail("Music Label", music.getLabel()));
        return details;
    }

    @Override
    protected String getHeader() {
        return this.music.getArtist() + "-" + this.music.getLabel();
    }
}
