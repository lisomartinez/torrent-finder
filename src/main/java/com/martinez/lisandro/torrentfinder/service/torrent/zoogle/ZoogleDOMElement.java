package com.martinez.lisandro.torrentfinder.service.torrent.zoogle;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;
import lombok.Data;
import org.jsoup.nodes.Element;

@Data
public class ZoogleDOMElement implements DOMElement {

    private Element element;

    public ZoogleDOMElement(Element element) {
        this.element = element;
    }

    public Element content() {
        return element;
    }

}
