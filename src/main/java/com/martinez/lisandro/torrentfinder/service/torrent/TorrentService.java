package com.martinez.lisandro.torrentfinder.service.torrent;

import com.martinez.lisandro.torrentfinder.model.TorrentInfo;

public interface TorrentService {
    TorrentInfo getTorrents(int showId, String showName, int seasonNumber, int episodeNumber);
}
