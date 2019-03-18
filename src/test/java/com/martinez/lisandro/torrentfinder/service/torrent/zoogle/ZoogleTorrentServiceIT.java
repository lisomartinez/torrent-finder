package com.martinez.lisandro.torrentfinder.service.torrent.zoogle;

import com.martinez.lisandro.torrentfinder.model.TorrentInfo;
import com.martinez.lisandro.torrentfinder.service.torrent.EpisodeParser;
import com.martinez.lisandro.torrentfinder.service.torrent.TorrentService;
import com.martinez.lisandro.torrentfinder.service.torrent.WebClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@ActiveProfiles("dev")
class ZoogleTorrentServiceIT {

    @Autowired
    private TorrentService torrentService;

    @Autowired
    private URLConstructor urlConstructor;

    @Autowired
    private EpisodeParser episodeParser;

    @Autowired
    private WebClient webClient;

    @Test
    void getTorrent_validShowIdAndShowNameAndSeasonNumberAndEpisodeNumber() {

        final int showId = 1;
        final String showName = "under the dome";
        final int seasonNumber = 1;
        final int episodeNumber = 1;
        TorrentInfo torrents = torrentService.getTorrents(showId, showName, seasonNumber, episodeNumber);
        assertThat(torrents.getTorrents().size()).isEqualTo(5);
    }
}