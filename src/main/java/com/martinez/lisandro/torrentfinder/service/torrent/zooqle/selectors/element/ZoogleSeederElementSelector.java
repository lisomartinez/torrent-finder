package com.martinez.lisandro.torrentfinder.service.torrent.zooqle.selectors.element;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;
import com.martinez.lisandro.torrentfinder.service.torrent.zooqle.selectors.ElementSelector;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class ZoogleSeederElementSelector implements ElementSelector {
    private static final String CRITERIA = "td:nth-child(6) > div:nth-child(1) > div:nth-child(1)";

    @Override
    public String apply(DOMElement element) {
        return ((Element) element.content()).select(CRITERIA).text();
    }
}
