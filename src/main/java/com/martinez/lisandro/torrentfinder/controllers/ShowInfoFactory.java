package com.martinez.lisandro.torrentfinder.controllers;

import com.martinez.lisandro.torrentfinder.model.RequestData;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShowInfoFactory {
    private static final String SHOW_ID = "showId";
    private static final String SHOW_NAME = "showName";
    private static final String SEASON_NUMBER = "seasonNumber";
    private static final String EPISODE_NUMBER = "episodeNumber";

    public RequestData from(Map<String, String> params) {
        Integer showId = Integer.valueOf(params.get(SHOW_ID));
        String showName = params.get(SHOW_NAME);
        Integer seasonNumber = Integer.valueOf(params.get(SEASON_NUMBER));
        Integer episodeNumber = Integer.valueOf(params.get(EPISODE_NUMBER));
        return new RequestData(showId, showName, seasonNumber, episodeNumber);
    }

}
