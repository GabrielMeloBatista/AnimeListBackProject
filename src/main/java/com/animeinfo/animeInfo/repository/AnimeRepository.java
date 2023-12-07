package com.animeinfo.animeInfo.repository;

import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.api.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends CrudRepository<Anime> {
    List<Anime> findAnimeByNomeContaining(String name);
}
