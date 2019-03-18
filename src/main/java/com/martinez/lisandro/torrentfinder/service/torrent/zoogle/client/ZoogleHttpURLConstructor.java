package com.martinez.lisandro.torrentfinder.service.torrent.zoogle.client;

import org.springframework.stereotype.Service;

@Service
public class ZoogleHttpURLConstructor implements ZoogleURLConstructor {
    private static final String BASE_URL = "https://zoogle.com";
    private static final String SEARCH = "https://zoogle.com/search?q=";

    @Override
    public String getTorrentsPageURL(String torrentName) {
        return SEARCH + torrentName;
    }
}
