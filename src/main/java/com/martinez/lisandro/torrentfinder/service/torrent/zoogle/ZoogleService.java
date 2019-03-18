package com.martinez.lisandro.torrentfinder.service.torrent.zoogle;

import com.martinez.lisandro.torrentfinder.model.Torrent;

import java.io.IOException;
import java.util.List;

public interface ZoogleService {
    List<Torrent> getEpisodeTorrents(String showName, int seasonNumber, int episodeNumber) throws IOException;
}
