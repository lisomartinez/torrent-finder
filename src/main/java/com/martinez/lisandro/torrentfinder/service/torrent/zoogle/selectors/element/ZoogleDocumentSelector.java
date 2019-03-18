package com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.element;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMDocument;
import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;
import com.martinez.lisandro.torrentfinder.service.torrent.zoogle.ZoogleDOMElement;
import com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.DocumentSelector;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ZoogleDocumentSelector implements DocumentSelector {
    private static final String CRITERIA = "table > tbody > tr";

    @Override
    public List<DOMElement> apply(DOMDocument document) {
        Document content = document.content();
        Elements elements = content.select(CRITERIA);
        return elements.stream().map(ZoogleDOMElement::new).collect(Collectors.toList());
    }
}
