package com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.criteria;

import com.martinez.lisandro.torrentfinder.model.Resolution;
import com.martinez.lisandro.torrentfinder.model.Torrent;
import com.martinez.lisandro.torrentfinder.model.TorrentList;
import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.TorrentSortCriteria;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class HDReadyMostSeedersSortCriteria implements TorrentSortCriteria {
    @Override
    public Optional<Torrent> apply(TorrentList info) {
        List<Torrent> torrents;
        if (info == null) {
            return Optional.empty();
        } else {
            torrents = info.getTorrents();
            sort(torrents);
            if (torrents.size() >= 1) {
                return Optional.of(torrents.get(0));
            } else {
                return Optional.empty();
            }
        }
    }

    @Override
    public List<Torrent> sort(List<Torrent> torrents) {
        return torrents.stream()
                .filter(t -> t.getResolution().equals(Resolution.RESOLUTION_720P))
                .sorted(comparing(Torrent::getSeeders).reversed())
                .collect(Collectors.toList());
    }
}
