package com.martinez.lisandro.torrentfinder.service.torrent.zooqle;

public interface URLConstructor {
    String getTorrentsPageURL(String torrentName, int seasonNumber, int episodeNumber);
}
