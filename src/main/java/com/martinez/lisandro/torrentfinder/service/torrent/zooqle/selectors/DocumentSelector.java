package com.martinez.lisandro.torrentfinder.service.torrent.zooqle.selectors;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMDocument;
import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;

import java.util.List;

public interface DocumentSelector {
    List<DOMElement> apply(DOMDocument document);
}
