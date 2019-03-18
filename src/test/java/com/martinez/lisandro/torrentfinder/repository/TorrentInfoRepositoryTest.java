package com.martinez.lisandro.torrentfinder.repository;

import com.martinez.lisandro.torrentfinder.model.Torrent;
import com.martinez.lisandro.torrentfinder.model.TorrentInfo;
import com.martinez.lisandro.torrentfinder.utils.TorrentFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("dev")
class TorrentInfoRepositoryTest {

    private static final Logger log = LogManager.getLogger();

    @Autowired
    private TorrentInfoRepository torrentInfoRepository;

    @Test
    void saveTorrentInfo_ShouldReturnSavedInstance() {
        TorrentInfo torrentInfo = TorrentFactory.createTorrentInfo();
        TorrentInfo saved = torrentInfoRepository.save(torrentInfo);

        log.info("------------------------------------------> " + saved);

        assertThat(saved).isEqualTo(torrentInfo);
    }

    @Test
    void saveTorrentInfoAndRemoveTorrent_ShouldRetrieveUpdatedContent() {
        TorrentInfo torrentInfo = TorrentFactory.createTorrentInfo();
        TorrentInfo saved = torrentInfoRepository.save(torrentInfo);

        log.info("------------------------------------------> " + saved);
        assertThat(saved).isEqualTo(torrentInfo);

        saved.getTorrents().remove(0);
        saved = torrentInfoRepository.save(saved);
        log.info("------------------------------------------> " + saved);
        assertThat(saved.getTorrents().size()).isEqualTo(0);
    }

    @Test
    void saveTorrentInfoAndAddTorrent_ShouldRetrieveUpdatedContent() {
        TorrentInfo torrentInfo = TorrentFactory.createTorrentInfo();
        TorrentInfo saved = torrentInfoRepository.save(torrentInfo);

        log.info("------------------------------------------> " + saved);
        assertThat(saved).isEqualTo(torrentInfo);

        saved.getTorrents().add(Torrent.builder().build());
        saved.getTorrents().add(Torrent.builder().build());
        saved.getTorrents().add(Torrent.builder().build());

        TorrentInfo result = torrentInfoRepository.save(saved);

        assertThat(result.getTorrents().size()).isEqualTo(4);
    }


}