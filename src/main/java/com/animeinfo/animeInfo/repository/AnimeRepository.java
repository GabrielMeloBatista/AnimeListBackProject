package com.animeinfo.animeInfo.repository;

import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.api.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository extends CrudRepository<Anime> {
}
