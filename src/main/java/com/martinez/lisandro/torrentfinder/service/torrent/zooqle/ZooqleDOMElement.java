package com.martinez.lisandro.torrentfinder.service.torrent.zooqle;

import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;
import lombok.Data;
import org.jsoup.nodes.Element;

@Data
public class ZooqleDOMElement implements DOMElement {

    private Element element;

    public ZooqleDOMElement(Element element) {
        this.element = element;
    }

    public Element content() {
        return element;
    }

}
