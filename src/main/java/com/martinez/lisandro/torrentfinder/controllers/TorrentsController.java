package com.martinez.lisandro.torrentfinder.controllers;

import com.martinez.lisandro.torrentfinder.dto.TorrentDto;
import com.martinez.lisandro.torrentfinder.model.RequestData;
import com.martinez.lisandro.torrentfinder.model.TorrentList;
import com.martinez.lisandro.torrentfinder.service.torrent.TorrentService;
import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.SearchCriteriaMap;
import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.TorrentSearchCriteriaFactory;
import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.TorrentSortCriteria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/torrents")
public class TorrentsController {
    public static final String ALL_TORRENTS = "/all";
    public static final String BEST = "/best";

    private TorrentService torrentService;

    private TorrentSearchCriteriaFactory searchCriteria;

    private ShowInfoFactory showInfoFactory;

    private ModelMapper mapper;

    private SearchCriteriaMap searchCriteriaMap;

    @Autowired
    public TorrentsController(TorrentService torrentService, TorrentSearchCriteriaFactory searchCriteria, ShowInfoFactory showInfoFactory, ModelMapper mapper, SearchCriteriaMap searchCriteriaMap) {
        this.torrentService = torrentService;
        this.searchCriteria = searchCriteria;
        this.showInfoFactory = showInfoFactory;
        this.searchCriteriaMap = searchCriteriaMap;
        this.mapper = mapper;
    }

    @GetMapping(ALL_TORRENTS)
    @ResponseStatus(HttpStatus.OK)
    public TorrentList getTorrents(@RequestParam Map<String, String> params) {
        RequestData requestData = showInfoFactory.from(params);
        TorrentSortCriteria criteria = searchCriteriaMap.getOrDefault(params.get("mode"));
        return torrentService.getTorrents(requestData, criteria);
    }

    @GetMapping(BEST)
    @ResponseStatus(HttpStatus.OK)
    public TorrentDto getBest(@RequestParam Map<String, String> params) {
        RequestData requestData = showInfoFactory.from(params);
        TorrentSortCriteria criteria = searchCriteriaMap.getOrDefault(params.get("mode"));
        return mapper.map(torrentService.getTorrent(requestData, criteria), TorrentDto.class);
    }
}
