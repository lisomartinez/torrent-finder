package com.martinez.lisandro.torrentfinder.service.torrent.zoogle;

import com.martinez.lisandro.torrentfinder.model.Torrent;
import com.martinez.lisandro.torrentfinder.service.torrent.DOMDocument;
import com.martinez.lisandro.torrentfinder.service.torrent.WebClient;
import com.martinez.lisandro.torrentfinder.service.torrent.WebPage;
import com.martinez.lisandro.torrentfinder.service.torrent.zoogle.client.ZoogleURLConstructor;
import com.martinez.lisandro.torrentfinder.service.torrent.zoogle.parsers.ZoogleEpisodeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoogleServiceImpl implements ZoogleService {

    private WebClient webClient;

    private ZoogleURLConstructor zoogleURLConstructor;

    private ZoogleEpisodeParser parser;

    private StringBuilder sb;

    @Autowired
    public ZoogleServiceImpl(WebClient webClient, ZoogleURLConstructor zoogleURLConstructor, ZoogleEpisodeParser parser) {
        this.webClient = webClient;
        this.zoogleURLConstructor = zoogleURLConstructor;
        this.parser = parser;
        this.sb = new StringBuilder();
    }

    @Override
    public List<Torrent> getEpisodeTorrents(String showName, int seasonNumber, int episodeNumber) {
        sb.setLength(0);
        String torrentName = sb.append(withOutSpecialChars(showName))
                .append(" S")
                .append(seasonNumber)
                .append("E")
                .append(episodeNumber).toString();

        String url = zoogleURLConstructor.getTorrentsPageURL(torrentName);

        WebPage webPage = webClient.fetchWebPage(url);
        DOMDocument document = new ZoogleDOMDocument(webPage);
        return parser.parseDOMDocument(document);
    }

    private String withOutSpecialChars(String showName) {
        return null;
    }
}
