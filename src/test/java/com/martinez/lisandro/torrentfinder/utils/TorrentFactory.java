package com.martinez.lisandro.torrentfinder.utils;

import com.martinez.lisandro.torrentfinder.model.Torrent;
import com.martinez.lisandro.torrentfinder.model.TorrentInfo;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.util.Arrays.asList;

public class TorrentFactory {
    public static Torrent createTorrent() {
        return Torrent.builder()
                .withTitle("Under The Dome S03E012")
                .withSize(1024)
                .withMagnetLink("magnet:?xt=urn:btih:5092B9075E02FA76D82671014A4C704DF6C9E095&dn=%5Bzooqle.com%5D%20Under%20the%20Dome%20S03E12%20720p%20HDTV%20X264-DIMENSION&tr=http://sugoi.pomf.se/announce&tr=http://explodie.org:6969/announce&tr=http://tracker.pomf.se/announce&tr=http://tracker1.itzmx.com:8080/announce&tr=http://open.acgtracker.com:1096/announce")
                .withSeeders(3)
                .withLeechers(1)
                .build();
    }

    public static TorrentInfo createTorrentInfo() {
        return TorrentInfo.builder()
                .withShowId(1)
                .withShowName("Under The Dome")
                .withSeasonNumber(3)
                .withEpisodeNumber(12)
                .withTorrents(new ArrayList<>(asList(createTorrent())))
                .withLastUpdate(LocalDateTime.of(2010, 2, 12, 21, 0))
                .build();
    }
}
