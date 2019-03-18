package com.martinez.lisandro.torrentfinder.repository;

import com.martinez.lisandro.torrentfinder.model.TorrentInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TorrentInfoRepository extends MongoRepository<TorrentInfo, String> {
}
