package com.martinez.lisandro.torrentfinder.service.torrent.zoogle;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMDocument;
import com.martinez.lisandro.torrentfinder.service.torrent.WebPage;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Data
public class ZoogleDOMDocument implements DOMDocument {
    private Document content;

    public ZoogleDOMDocument(WebPage content) {
        this.content = Jsoup.parse(content.getContent());
    }

    @Override
    public Document content() {
        return content;
    }
}
