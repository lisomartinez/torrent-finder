package com.martinez.lisandro.torrentfinder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TorrentTest {
    @Test
    void testEquals() {
        Torrent torrent1 = Torrent.builder()
                .withTitle("Under The Dome S03E012")
                .withSize(1024)
                .withMagnetLink("AAA")
                .withSeeders(3)
                .withLeechers(1)
                .build();

        Torrent torrent2 = Torrent.builder()
                .withTitle("Under The Dome S03E012")
                .withSize(1024)
                .withMagnetLink("ZZZ")
                .withSeeders(3)
                .withLeechers(1)
                .build();

        Torrent torrent3 = Torrent.builder()
                .withTitle("OTHER NAME")
                .withMagnetLink("AAA")
                .build();

        assertThat(torrent1).isNotEqualTo(torrent2);
        assertThat(torrent1).isEqualTo(torrent3);
    }
}