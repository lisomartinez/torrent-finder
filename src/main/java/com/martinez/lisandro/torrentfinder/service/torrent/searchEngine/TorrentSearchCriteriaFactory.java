package com.martinez.lisandro.torrentfinder.service.torrent.searchEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TorrentSearchCriteriaFactory {
    private SearchCriteriaMap searchCriteriaMap;

    @Autowired
    public TorrentSearchCriteriaFactory(SearchCriteriaMap searchCriteriaMap) {
        this.searchCriteriaMap = searchCriteriaMap;
    }

    public TorrentSortCriteria from(Map<String, String> params) {
        String mode = params.get("mode");
        return searchCriteriaMap.getOrDefault(params.get("mode"));
    }

}
