package com.animeinfo.animeInfo.service;

import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.api.service.CrudService;

import java.util.List;

public interface AnimeService extends CrudService<Anime, Long> {
    List<Anime> search(String searchTerm);
}
