package com.animeinfo.animeInfo.repository;

import com.animeinfo.animeInfo.model.AnimeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeListRepository extends JpaRepository<AnimeList, Long> {
}
