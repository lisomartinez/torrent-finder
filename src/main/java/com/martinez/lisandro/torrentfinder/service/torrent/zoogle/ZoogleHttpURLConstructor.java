package com.martinez.lisandro.torrentfinder.service.torrent.zoogle;

import org.springframework.stereotype.Service;

@Service
public class ZoogleHttpURLConstructor implements URLConstructor {
    private static final String BASE_URL = "https://zoogle.com";
    private static final String SEARCH = "https://zoogle.com/search?q=";

    private StringBuilder sb;

    public ZoogleHttpURLConstructor() {
        this.sb = new StringBuilder();
    }

    @Override
    public String getTorrentsPageURL(String torrentName, int seasonNumber, int episodeNumber) {

        // i.e: "under the dome S01E12"
        String url = sb.append(SEARCH)
                .append(torrentName).append(' ')
                .append('S').append(seasonNumber)
                .append('E').append(episodeNumber)
                .toString();
        sb.setLength(0);
        return url;
    }
}
