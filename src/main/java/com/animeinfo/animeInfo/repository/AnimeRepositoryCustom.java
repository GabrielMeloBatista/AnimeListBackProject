package com.animeinfo.animeInfo.repository;

import com.animeinfo.animeInfo.model.Anime;

import java.util.List;

public interface AnimeRepositoryCustom {
    List<Anime>localizarPorAnime(Anime anime);
}
