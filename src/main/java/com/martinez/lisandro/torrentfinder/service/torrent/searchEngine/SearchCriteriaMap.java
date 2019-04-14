package com.martinez.lisandro.torrentfinder.service.torrent.searchEngine;

import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.criteria.BestResolutionMostSeedersSortCriteria;
import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.criteria.BestSpeedSortCriteria;
import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.criteria.HDReadyMostSeedersSortCriteria;
import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.criteria.MostSeedersSortCriteria;

import java.util.HashMap;
import java.util.Map;

public class SearchCriteriaMap {

    private Map<String, TorrentSortCriteria> map;

    private TorrentSortCriteria defaultCriteria;

    public SearchCriteriaMap() {
        map = new HashMap<>();
        defaultCriteria = new HDReadyMostSeedersSortCriteria();
        map.put("default", defaultCriteria);
        map.put("bestResolution", new BestResolutionMostSeedersSortCriteria());
        map.put("bestSpeed", new BestSpeedSortCriteria());
        map.put("mostSeeders", new MostSeedersSortCriteria());
    }

    public TorrentSortCriteria getOrDefault(String criteria) {
        if (criteria == null) return defaultCriteria;
        return map.getOrDefault(criteria, defaultCriteria);
    }

}
