package com.martinez.lisandro.torrentfinder.service.torrent.zooqle;

import com.martinez.lisandro.torrentfinder.model.RequestData;
import com.martinez.lisandro.torrentfinder.model.Torrent;
import com.martinez.lisandro.torrentfinder.model.TorrentList;
import com.martinez.lisandro.torrentfinder.repository.TorrentInfoRepository;
import com.martinez.lisandro.torrentfinder.service.torrent.EpisodeParser;
import com.martinez.lisandro.torrentfinder.service.torrent.TorrentService;
import com.martinez.lisandro.torrentfinder.service.torrent.WebClient;
import com.martinez.lisandro.torrentfinder.service.torrent.WebPage;
import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.TorrentSortCriteria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZooqleTorrentService implements TorrentService {

    private static final int TTL = 1;

    private URLConstructor urlConstructor;

    private WebClient client;

    private EpisodeParser parser;

    private TorrentInfoRepository repository;

    @Autowired
    public ZooqleTorrentService(URLConstructor urlConstructor, WebClient client, EpisodeParser parser, TorrentInfoRepository repository, ModelMapper modelMapper) {
        this.urlConstructor = urlConstructor;
        this.client = client;
        this.parser = parser;
        this.repository = repository;
    }

    @Override
    @Cacheable(value = "torrents")
    public TorrentList getTorrents(RequestData requestData, TorrentSortCriteria searchCriteria) {
        Optional<TorrentList> torrentInfo = repository.findByShowIdAndSeasonNumberAndEpisodeNumber(requestData.getShowId(), requestData.getSeasonNumber(), requestData.getEpisodeNumber());

        if (torrentInfo.isPresent() && lastUpdateTimeIsLessThanTTL(torrentInfo.get())) {
            TorrentList torrentList = torrentInfo.get();
            torrentList.setTorrents(searchCriteria.sort(torrentList.getTorrents()));
            return torrentList;
        } else {
            List<Torrent> sortedTorrents = searchCriteria.sort(getTorrentsFromZooqleWith(requestData));
            return repository.save(createTorrentInfoWith(requestData, sortedTorrents));
        }
    }

    private boolean lastUpdateTimeIsLessThanTTL(TorrentList torrentList) {
        return Duration.between(torrentList.getLastUpdate(), LocalDateTime.now().withNano(0)).toHours() < TTL;
    }

    private List<Torrent> getTorrentsFromZooqleWith(RequestData requestData) {
        String url = urlConstructor.getTorrentsPageURL(requestData.getShowName(),
                requestData.getSeasonNumber(),
                requestData.getEpisodeNumber());
        WebPage webPage = client.fetchWebPage(url);
        List<Torrent> torrents = parser.parseDOMDocument(new ZooqleDOMDocument(webPage));
        if (torrents == null) {
            return new ArrayList<>();
        } else {
            return torrents;
        }
    }

    private TorrentList createTorrentInfoWith(RequestData requestData, List<Torrent> torrents) {
        return TorrentList.builder()
                .showId(requestData.getShowId())
                .showName(requestData.getShowName())
                .seasonNumber(requestData.getSeasonNumber())
                .episodeNumber(requestData.getEpisodeNumber())
                .torrents(torrents)
                .lastUpdate(LocalDateTime.now().withNano(0))
                .build();
    }

    @Override
    public Torrent getTorrent(RequestData requestData, TorrentSortCriteria searchCriteria) {
        TorrentList torrentInfo = getTorrents(requestData, searchCriteria);
        if (torrentInfo.areTorrentsPresent()) {
            return torrentInfo.getFirstTorrent();
        } else {
            return Torrent.empty();
        }
    }
}
