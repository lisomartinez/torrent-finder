package com.martinez.lisandro.torrentfinder.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Getter
public class TorrentInfo {

    @Id
    private String id;
    private int showId;
    private String showName;
    private int seasonNumber;
    private int episodeNumber;
    private List<Torrent> torrents;
    private LocalDateTime lastUpdate;


    public TorrentInfo(int showId, String showName, int seasonNumber, int episodeNumber, List<Torrent> torrents, LocalDateTime lastUpdate) {
        this.showId = showId;
        this.showName = showName;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
        this.torrents = torrents;
        this.lastUpdate = lastUpdate;
    }

    public TorrentInfo(String id, int showId, String showName, int seasonNumber, int episodeNumber, List<Torrent> torrents, LocalDateTime lastUpdate) {
        this.id = id;
        this.showId = showId;
        this.showName = showName;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
        this.torrents = torrents;
        this.lastUpdate = lastUpdate;
    }

    public static TorrentInfoBuilder builder() {
        return new TorrentInfoBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TorrentInfo that = (TorrentInfo) o;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String getId() {
        return id;
    }

    public int getShowId() {
        return showId;
    }

    public String getShowName() {
        return showName;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public List<Torrent> getTorrents() {
        return torrents;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public String toString() {
        return "TorrentInfo{" +
                "id='" + id + '\'' +
                ", showId=" + showId +
                ", showName='" + showName + '\'' +
                ", seasonNumber=" + seasonNumber +
                ", episodeNumber=" + episodeNumber +
                ", torrents=" + torrents +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public static class TorrentInfoBuilder {
        private String id = null;
        private int showId;
        private String showName;
        private int seasonNumber;
        private int episodeNumber;
        private List<Torrent> torrents;
        private LocalDateTime lastUpdate;

        public TorrentInfoBuilder withId(String id) {
            this.id = id;
            return this;
        }

        public TorrentInfoBuilder withShowId(int showId) {
            this.id = id;
            return this;
        }

        public TorrentInfoBuilder withShowName(String showName) {
            this.showName = showName;
            return this;
        }

        public TorrentInfoBuilder withSeasonNumber(int seasonNumber) {
            this.seasonNumber = seasonNumber;
            return this;
        }

        public TorrentInfoBuilder withEpisodeNumber(int episodeNumber) {
            this.episodeNumber = episodeNumber;
            return this;
        }

        public TorrentInfoBuilder withTorrents(List<Torrent> torrents) {
            this.torrents = torrents;
            return this;
        }

        public TorrentInfoBuilder withLastUpdate(LocalDateTime lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public TorrentInfo build() {
            if (id == null) {
                return new TorrentInfo(showId, showName, seasonNumber, episodeNumber, torrents, lastUpdate);
            } else {
                return new TorrentInfo(id, showId, showName, seasonNumber, episodeNumber, torrents, lastUpdate);
            }
        }
    }
}
