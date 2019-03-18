package com.martinez.lisandro.torrentfinder.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class TorrentInfo {

    @Id
    private String id;
    private int showId;
    private String showName;
    private int seasonNumber;
    private int episodeNumber;
    @DBRef
    private List<Torrent> torrents;
}
