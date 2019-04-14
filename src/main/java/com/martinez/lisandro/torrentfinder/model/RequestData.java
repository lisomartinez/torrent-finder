package com.martinez.lisandro.torrentfinder.model;

public class RequestData {
    private final int showId;
    private final String showName;
    private final int seasonNumber;
    private final int episodeNumber;

    public RequestData(int showId, String showName, int seasonNumber, int episodeNumber) {
        this.showId = showId;
        this.showName = showName;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }

    public int getShowId() {
        return showId;
    }

    public String getShowName() {
        return showName;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }
}
