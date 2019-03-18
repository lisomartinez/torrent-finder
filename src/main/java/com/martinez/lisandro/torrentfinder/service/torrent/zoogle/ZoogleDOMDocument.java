package com.martinez.lisandro.torrentfinder.service.torrent.zoogle;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMDocument;
import com.martinez.lisandro.torrentfinder.service.torrent.WebPage;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class ZoogleDOMDocument implements DOMDocument {
    private Document content;

    public ZoogleDOMDocument() {
    }

    @Override
    public Document content() {
        return content;
    }

    public DOMDocument setContent(WebPage content) {
        this.content = Jsoup.parse(content.getContent());
        return this;
    }
}
