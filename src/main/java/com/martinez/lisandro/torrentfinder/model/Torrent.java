package com.martinez.lisandro.torrentfinder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Torrent {
    private String title;
    private String magnetLink;
    private Resolution resolution;
    private Codec codec;
    private ReleaseType releaseType;
    private Size size;
    private int seeders;
    private int leechers;

    public static Torrent empty() {
        return new Torrent();
    }

}
