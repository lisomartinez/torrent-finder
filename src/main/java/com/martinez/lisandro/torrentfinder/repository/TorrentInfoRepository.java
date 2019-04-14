package com.martinez.lisandro.torrentfinder.repository;

import com.martinez.lisandro.torrentfinder.model.TorrentList;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface TorrentInfoRepository extends MongoRepository<TorrentList, String> {
    Optional<TorrentList> findByShowIdAndSeasonNumberAndEpisodeNumber(@NotNull int showId, int seasonNumber, int episodeNumber);
}
