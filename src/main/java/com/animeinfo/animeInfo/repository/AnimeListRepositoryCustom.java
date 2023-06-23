package com.animeinfo.animeInfo.repository;

import com.animeinfo.animeInfo.model.AnimeList;

import java.util.List;

public interface AnimeListRepositoryCustom {
    List<AnimeList>localizarPorAnime(AnimeList animeList);
}
