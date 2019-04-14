package com.martinez.lisandro.torrentfinder.service.torrent.zooqle.selectors.element;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;
import com.martinez.lisandro.torrentfinder.service.torrent.zooqle.selectors.ElementSelector;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class ZoogleSizeElementSelector implements ElementSelector {
    private static final String CRITERIA = "td:nth-child(4) .progress-bar";

    @Override
    public String apply(DOMElement element) {
        return ((Element) element.content()).select(CRITERIA).text();
    }
}
