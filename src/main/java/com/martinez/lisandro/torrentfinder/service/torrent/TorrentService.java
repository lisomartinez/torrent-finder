package com.martinez.lisandro.torrentfinder.service.torrent;

import com.martinez.lisandro.torrentfinder.model.RequestData;
import com.martinez.lisandro.torrentfinder.model.Torrent;
import com.martinez.lisandro.torrentfinder.model.TorrentList;
import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.TorrentSortCriteria;

public interface TorrentService {
    TorrentList getTorrents(RequestData requestData, TorrentSortCriteria searchCriteria);

    Torrent getTorrent(RequestData requestData, TorrentSortCriteria searchCriteria);
}
