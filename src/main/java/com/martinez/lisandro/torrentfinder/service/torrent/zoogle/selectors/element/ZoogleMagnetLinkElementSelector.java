package com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.element;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;
import com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.ElementSelector;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class ZoogleMagnetLinkElementSelector implements ElementSelector {
    private static final String CRITERIA = "td:nth-child(3)  li:nth-child(2) a";

    @Override
    public String apply(DOMElement element) {
        Element link = element.content();
        return link.select(CRITERIA).attr("href");
    }
}
