package com.martinez.lisandro.torrentfinder.service.torrent.zoogle;

public interface URLConstructor {
    String getTorrentsPageURL(String torrentName, int seasonNumber, int episodeNumber);
}
