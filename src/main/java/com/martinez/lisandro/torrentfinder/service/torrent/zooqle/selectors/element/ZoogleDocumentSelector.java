package com.martinez.lisandro.torrentfinder.service.torrent.zooqle.selectors.element;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMDocument;
import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;
import com.martinez.lisandro.torrentfinder.service.torrent.zooqle.ZooqleDOMElement;
import com.martinez.lisandro.torrentfinder.service.torrent.zooqle.selectors.DocumentSelector;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ZoogleDocumentSelector implements DocumentSelector {
    private static final String CRITERIA = "table > tbody > tr";

    @Override
    public List<DOMElement> apply(DOMDocument document) {
        return ((Document) document.content())
                .select(CRITERIA)
                .stream()
                .map(ZooqleDOMElement::new)
                .collect(Collectors.toList());
    }
}
