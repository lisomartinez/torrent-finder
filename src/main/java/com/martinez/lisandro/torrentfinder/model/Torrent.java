package com.martinez.lisandro.torrentfinder.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Torrent {

    private final String title;

    private final int size;

    private final String magnetLink;

    private final int seeders;

    private final int leechers;

    public Torrent(String title, int size, String magnetLink, int seeders, int leechers) {
        this.title = title;
        this.size = size;
        this.magnetLink = magnetLink;
        this.seeders = seeders;
        this.leechers = leechers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Torrent torrent = (Torrent) o;

        return magnetLink.equals(torrent.magnetLink);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + size;
        result = 31 * result + magnetLink.hashCode();
        result = 31 * result + seeders;
        result = 31 * result + leechers;
        return result;
    }

    public String getTitle() {
        return title;
    }

    public int getSize() {
        return size;
    }

    public String getMagnetLink() {
        return magnetLink;
    }

    public int getSeeders() {
        return seeders;
    }

    public int getLeechers() {
        return leechers;
    }

    @Override
    public String toString() {
        return "Torrent{" +
                "title='" + title + '\'' +
                ", size=" + size +
                ", magnetLink='" + magnetLink + '\'' +
                ", seeders=" + seeders +
                ", leechers=" + leechers +
                '}';
    }

    public static TorrentBuilder builder() {
        return new TorrentBuilder();
    }

    public static class TorrentBuilder {
        private String title;
        private int size;
        private String magnetLink;
        private int seeders;
        private int leechers;

        public TorrentBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public TorrentBuilder withSize(int size) {
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
