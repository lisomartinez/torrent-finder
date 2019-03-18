package com.martinez.lisandro.torrentfinder.service.torrent;

import com.martinez.lisandro.torrentfinder.model.Torrent;

import java.util.List;

public interface EpisodeParser {
    List<Torrent> parseDOMDocument(DOMDocument document);
}
