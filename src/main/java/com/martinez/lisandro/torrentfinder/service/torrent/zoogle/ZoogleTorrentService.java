package com.martinez.lisandro.torrentfinder.service.torrent.zoogle;

import com.martinez.lisandro.torrentfinder.model.Torrent;
import com.martinez.lisandro.torrentfinder.model.TorrentInfo;
import com.martinez.lisandro.torrentfinder.service.torrent.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ZoogleTorrentService implements TorrentService {

    private URLConstructor urlConstructor;

    private WebClient webClient;

    private EpisodeParser episodeParser;

    private DOMDocument document;

    private WebPage webPage;

    @Autowired
    public ZoogleTorrentService(URLConstructor urlConstructor, WebClient webClient, EpisodeParser episodeParser) {
        this.urlConstructor = urlConstructor;
        this.webClient = webClient;
        this.episodeParser = episodeParser;
    }

    @Override
    public TorrentInfo getTorrents(int showId, String showName, int seasonNumber, int episodeNumber) {
        String url = urlConstructor.getTorrentsPageURL(showName, seasonNumber, episodeNumber);
        WebPage webPage = webClient.fetchWebPage(url);
        List<Torrent> torrents = episodeParser.parseDOMDocument(document.setContent(webPage));
        return TorrentInfo.builder()
                .withShowId(showId)
                .withShowName(showName)
                .withSeasonNumber(seasonNumber)
                .withEpisodeNumber(episodeNumber)
                .withTorrents(torrents)
                .withLastUpdate(LocalDateTime.now())
                .build();
    }
}
