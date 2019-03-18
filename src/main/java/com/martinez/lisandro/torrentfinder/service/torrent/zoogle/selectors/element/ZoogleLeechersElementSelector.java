package com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.element;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;
import com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.ElementSelector;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class ZoogleLeechersElementSelector implements ElementSelector {
    private static final String CRITERIA = "td:nth-child(6) div:nth-child(2)";

    @Override
    public String apply(DOMElement element) {
        Element leechers = element.content();
        return leechers.select(CRITERIA).text();
    }
}
