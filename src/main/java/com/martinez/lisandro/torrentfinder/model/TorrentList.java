package com.martinez.lisandro.torrentfinder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TorrentList {

    @Id
    private String id;
    private int showId;
    private String showName;
    private int seasonNumber;
    private int episodeNumber;
    private List<Torrent> torrents;
    private LocalDateTime lastUpdate;

    public boolean areTorrentsPresent() {
        return !this.torrents.isEmpty();
    }

    public Torrent getFirstTorrent() {
        return this.torrents.get(0);
    }
}
