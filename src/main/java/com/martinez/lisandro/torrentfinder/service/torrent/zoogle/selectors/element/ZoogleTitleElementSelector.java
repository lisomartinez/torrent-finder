package com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.element;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;
import com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.ElementSelector;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class ZoogleTitleElementSelector implements ElementSelector {
    private static final String CRITERIA = "td:nth-child(2) a";

    @Override
    public String apply(DOMElement element) {
        Element title = element.content();
        return title.select(CRITERIA).text();
    }
}
