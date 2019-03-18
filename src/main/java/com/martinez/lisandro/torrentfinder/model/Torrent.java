package com.martinez.lisandro.torrentfinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Torrent {

    @Id
    private String id;

    private String title;

    private double size;

    private String magnetLink;

    private int seeders;

    private int leechers;

    public Torrent(String title, double size, String magnetLink, int seeders, int leechers) {
        this.title = title;
        this.size = size;
        this.magnetLink = magnetLink;
        this.seeders = seeders;
        this.leechers = leechers;
    }

    public static TorrentBuilder builder() {
        return new TorrentBuilder();
    }

    public static class TorrentBuilder {
        private String title;
        private double size;
        private String magnetLink;
        private int seeders;
        private int leechers;

        public TorrentBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public TorrentBuilder withSize(double size) {
            this.size = size;
            return this;
        }

        public TorrentBuilder withMagnetLink(String magnetLink) {
            this.magnetLink = magnetLink;
            return this;
        }

        public TorrentBuilder withSeeders(int seeders) {
            this.seeders = seeders;
            return this;
        }

        public TorrentBuilder withLeechers(int leechers) {
            this.leechers = leechers;
            return this;
        }

        public Torrent build() {
            return new Torrent(title, size, magnetLink, seeders, leechers);
        }
    }
}
