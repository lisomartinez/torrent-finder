package com.martinez.lisandro.torrentfinder.service.torrent;


public interface DOMDocument {
    <T> T content();

    DOMDocument setContent(WebPage content);
}