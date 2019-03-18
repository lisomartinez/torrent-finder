package com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.element;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;
import com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.ElementSelector;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class ZoogleTorrentElementSelector implements ElementSelector {
    private static final String CRITERIA = "table > tbody > tr";

    @Override
    public String apply(DOMElement element) {
        Elements elements = element.content();
        return elements.select(CRITERIA).text();
    }
}
