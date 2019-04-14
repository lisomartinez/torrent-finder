package com.martinez.lisandro.torrentfinder.service.torrent.zooqle.parsers;

import com.martinez.lisandro.torrentfinder.exceptions.ZoogleWebClientErrorException;
import com.martinez.lisandro.torrentfinder.service.torrent.WebPage;
import com.martinez.lisandro.torrentfinder.service.torrent.zooqle.client.ZooqleWebClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ZooqleWebClientTest {
    private ZooqleWebClient client;

    @BeforeEach
    void setUp() {
        client = new ZooqleWebClient();
    }

    @Test
    void fetchWebPage_validUrl_ShouldReturnContentAsString() throws IOException {
        String episodeUrl = "https://zooqle.com/search?q=under+the+dome+s03e13";
//        String episodeUrl = "https://zoogle.com/search?q=under+the+dome+S03E12 ";
        WebPage response = client.fetchWebPage(episodeUrl);

        assertThat(response.getContent()).isNotBlank();
    }

    @Test
    void fetchWebPage_invalidURL_ShouldThrowZoogleWebClientErrorException() {
        String episodeUrl = "https://ooqle.com/search?q=under+the+dome+s03e13";
        assertThrows(ZoogleWebClientErrorException.class, () -> client.fetchWebPage(episodeUrl));
    }


}