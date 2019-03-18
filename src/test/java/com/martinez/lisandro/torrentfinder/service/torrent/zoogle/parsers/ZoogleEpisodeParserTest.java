package com.martinez.lisandro.torrentfinder.service.torrent.zoogle.parsers;

import com.martinez.lisandro.torrentfinder.model.Torrent;
import com.martinez.lisandro.torrentfinder.service.torrent.DOMDocument;
import com.martinez.lisandro.torrentfinder.service.torrent.WebPage;
import com.martinez.lisandro.torrentfinder.service.torrent.zoogle.ZoogleDOMDocument;
import com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.element.*;
import com.martinez.lisandro.torrentfinder.utils.ZoogleUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class ZoogleEpisodeParserTest {

    private ZoogleEpisodeParser episodeParser;



    @BeforeEach
    void setUp() {
        episodeParser = new ZoogleEpisodeParser(new ZoogleDocumentSelector(),
                new ZoogleTitleElementSelector(),
                new ZoogleSizeElementSelector(),
                new ZoogleMagnetLinkElementSelector(),
                new ZoogleLeechersElementSelector(),
                new ZoogleSeederElementSelector());
    }

    @Test
    void parseDOMDocument() {
//        WebPage webPage = webClient.fetchWebPage("https://zooqle.com/search?q=under+the+dome+s03e12");
        WebPage webPage = new WebPage().setContent(ZoogleUtils.getZooglePage());
        DOMDocument document = new ZoogleDOMDocument().setContent(webPage);
        List<Torrent> torrents = episodeParser.parseDOMDocument(document);

        Logger logger = LogManager.getLogger();
        torrents.stream().forEach(logger::info);
        assertThat(torrents.size()).isEqualTo(5);
    }

}