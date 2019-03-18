package com.martinez.lisandro.torrentfinder.service.torrent.zoogle.parsers;

import com.martinez.lisandro.torrentfinder.model.Torrent;
import com.martinez.lisandro.torrentfinder.service.torrent.DOMDocument;
import com.martinez.lisandro.torrentfinder.service.torrent.DOMElement;
import com.martinez.lisandro.torrentfinder.service.torrent.EpisodeParser;
import com.martinez.lisandro.torrentfinder.service.torrent.zoogle.selectors.element.*;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ZoogleEpisodeParser implements EpisodeParser {

    private static final Pattern TITLE = Pattern.compile("[^(<\\/?hl>)]");
    private static final Pattern LINK = Pattern.compile("(<.?hl>)(\\s)*");

    private ZoogleDocumentSelector documentSelector;

    private ZoogleTitleElementSelector titleCriteria;

    private ZoogleSizeElementSelector sizeCriteria;

    private ZoogleMagnetLinkElementSelector magnetLinkCriteria;

    private ZoogleLeechersElementSelector leechersCriteria;

    private ZoogleSeederElementSelector seederCriteria;

    @Autowired
    public ZoogleEpisodeParser(ZoogleDocumentSelector documentSelector, ZoogleTitleElementSelector titleCriteria, ZoogleSizeElementSelector sizeCriteria, ZoogleMagnetLinkElementSelector magnetLinkCriteria, ZoogleLeechersElementSelector leechersCriteria, ZoogleSeederElementSelector seederCriteria) {
        this.documentSelector = documentSelector;
        this.titleCriteria = titleCriteria;
        this.sizeCriteria = sizeCriteria;
        this.magnetLinkCriteria = magnetLinkCriteria;
        this.leechersCriteria = leechersCriteria;
        this.seederCriteria = seederCriteria;
    }

    @Autowired

    @Override
    public List<Torrent> parseDOMDocument(DOMDocument document) {
//        LogManager.getLogger().info("////////////////////////// " + document);
        List<DOMElement> elements = documentSelector.apply(document);
        return elements.stream().map(this::parse).collect(Collectors.toList());
    }

    private Torrent parse(DOMElement element) {

//        LogManager.getLogger().info("EPISODE -----------------------------> \n " + element + "\n\n\n\n\n");
        String title = titleCriteria.apply(element);
        String size = sizeCriteria.apply(element);
        String magnetLink = magnetLinkCriteria.apply(element);
        String seeders = seederCriteria.apply(element);
        String leechers = leechersCriteria.apply(element);
        return Torrent.builder()
                .withTitle(parseTitle(title))
                .withSize(parseSize(size))
                .withMagnetLink(parseMagnetLink(magnetLink))
                .withSeeders(parseSeeders(seeders))
                .withLeechers(parseLeechers(leechers))
                .build();
    }

    private int parseLeechers(String leechers) {
        LogManager.getLogger().info("LEECHERS ------------------> " + leechers);
        return parseInteger(leechers);
    }

    private int parseInteger(String st) {
        int number = 0;
        try {
            number = Integer.parseInt(st);
        } catch (RuntimeException ex) {
            number = 0;
        }
        return number;
    }

    private int parseSeeders(String seeders) {
        LogManager.getLogger().info("SEEDERS ------------------> " + seeders);
        return parseInteger(seeders);
    }

    private String parseMagnetLink(String link) {
        LogManager.getLogger().info("MAGNET LINK ------------------> " + link);
        return link;
    }

    private String parseTitle(String titleHtml) {
        LogManager.getLogger().info("TITLE ------------------> " + titleHtml);

//        String title = TITLE.matcher(titleHtml).appendReplacement("");
//        title = title.replaceAll("\n", "");
//        LogManager.getLogger().info("TITLE ------------------> " + title);


        return titleHtml;
    }

    private double parseSize(String sizeHtml) {
        LogManager.getLogger().info("SIZE ------------------> " + sizeHtml);
        String[] sizeAndUnitMeasure = sizeHtml.split(" ");

        if (sizeAndUnitMeasure.length < 2) return 0.0;

        double size = parseDouble(sizeAndUnitMeasure[0]);
        String unitMeasure = sizeAndUnitMeasure[1];

        if (unitMeasure.equals("GB")) {
            size = size * 1024;
        }
        return size;
    }

    private double parseDouble(String s) {
        double number;
        try {
            number = Double.parseDouble(s);
        } catch (RuntimeException ex) {
            number = 0;
        }
        return number;
    }
}
