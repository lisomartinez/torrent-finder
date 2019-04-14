package com.martinez.lisandro.torrentfinder.service.torrent.searchEngine;

import com.martinez.lisandro.torrentfinder.model.Torrent;
import com.martinez.lisandro.torrentfinder.model.TorrentList;

import java.util.List;
import java.util.Optional;

public interface TorrentSortCriteria {
    Optional<Torrent> apply(TorrentList info);

    List<Torrent> sort(List<Torrent> torrents);
}
