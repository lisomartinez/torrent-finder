package com.martinez.lisandro.torrentfinder;

import com.martinez.lisandro.torrentfinder.service.torrent.searchEngine.SearchCriteriaMap;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class TorrentFinderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TorrentFinderApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public SearchCriteriaMap searchCriteriaMap() {
		return new SearchCriteriaMap();
	}

}
