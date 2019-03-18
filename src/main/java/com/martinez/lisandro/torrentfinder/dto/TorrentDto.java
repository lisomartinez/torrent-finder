package com.martinez.lisandro.torrentfinder.dto;

import lombok.Data;

@Data
public class TorrentDto {
    private String showName;
    private int seasonNumber;
    private int episodeNumber;
    private String title;
    private String magnetLink;
    private int size;
    private int seeders;
    private int leechers;
}
