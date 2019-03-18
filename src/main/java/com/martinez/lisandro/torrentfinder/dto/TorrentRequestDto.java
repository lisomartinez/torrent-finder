package com.martinez.lisandro.torrentfinder.dto;

import lombok.Data;

@Data
public class TorrentRequestDto {
    private String showName;
    private int seasonNumber;
    private int episodeNumber;
}
