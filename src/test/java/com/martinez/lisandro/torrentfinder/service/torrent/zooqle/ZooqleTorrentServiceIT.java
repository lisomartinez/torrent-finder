package com.martinez.lisandro.torrentfinder.service.torrent.zooqle;

import com.martinez.lisandro.torrentfinder.model.RequestData;
import com.martinez.lisandro.torrentfinder.model.Torrent;
import com.martinez.lisandro.torrentfinder.model.TorrentList;
import com.martinez.lisandro.torrentfinder.repository.TorrentInfoRepository;
import com.martinez.lisandro.torrentfinder.service.torrent.EpisodeParser;
import com.martinez.lisandro.torrentfinder.service.torrent.TorrentService;
import com.martinez.lisandro.torrentfinder.service.torrent.WebClient;
import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.SearchCriteriaMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class ZooqleTorrentServiceIT {

    @Autowired
    private TorrentService torrentService;

    @Autowired
    private URLConstructor urlConstructor;

    @Autowired
    private EpisodeParser episodeParser;

    @Autowired
    private WebClient webClient;

    @Autowired
    private SearchCriteriaMap map;

    @Autowired
    private TorrentInfoRepository repo;

    @Test
    void getTorrent_validShowIdAndShowNameAndSeasonNumberAndEpisodeNumber() {

        final int showId = 1;
        final String showName = "under the dome";
        final int seasonNumber = 3;
        final int episodeNumber = 13;
        TorrentList torrents = torrentService.getTorrents(new RequestData(showId, showName, seasonNumber, episodeNumber), map.getOrDefault("default"));
        LogManager.getLogger().info(torrents);
        assertThat(torrents.getTorrents().size()).isEqualTo(6);
    }

    @Test
    void getTorrent_validShowInfoUpToDate_ShouldReturnInstanceFromDB() {

        final int showId = 1;
        final String showName = "under the dome";
        final int seasonNumber = 3;
        final int episodeNumber = 13;
        TorrentList torrents = torrentService.getTorrents(new RequestData(showId, showName, seasonNumber, episodeNumber), map.getOrDefault("default"));
        assertThat(torrents.getTorrents().size()).isEqualTo(6);

        Optional<TorrentList> byShowId = repo.findByShowIdAndSeasonNumberAndEpisodeNumber(torrents.getShowId(), seasonNumber, episodeNumber);
        assertThat(byShowId.isPresent()).isTrue();

        TorrentList torrents2 = torrentService.getTorrents(new RequestData(showId, showName, seasonNumber, episodeNumber), map.getOrDefault("default"));
        LogManager.getLogger().info(torrents2);

        assertThat(torrents2.getLastUpdate()).isEqualTo(torrents.getLastUpdate());
    }

    @Test
    void getTorrent_returnSortedByResoultion() {

        final int showId = 1;
        final String showName = "under the dome";
        final int seasonNumber = 3;
        final int episodeNumber = 13;
        TorrentList torrents = torrentService.getTorrents(new RequestData(showId, showName, seasonNumber, episodeNumber), map.getOrDefault("default"));
        Logger logger = LogManager.getLogger();
//                logger.info(torrents);
        torrents.getTorrents().stream().map(Torrent::getResolution).forEach(logger::info);
        assertThat(torrents.getTorrents().size()).isEqualTo(6);
    }

}