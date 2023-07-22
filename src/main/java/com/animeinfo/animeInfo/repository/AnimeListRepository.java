package com.animeinfo.animeInfo.repository;

import com.animeinfo.animeInfo.model.AnimeList;
import com.animeinfo.api.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeListRepository extends CrudRepository<AnimeList> {
}
