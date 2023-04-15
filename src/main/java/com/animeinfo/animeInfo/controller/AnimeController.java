package com.animeinfo.animeInfo.controller;

import com.animeinfo.animeInfo.dto.AnimeDTO;
import com.animeinfo.animeInfo.mapper.AnimeMapper;
import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.animeInfo.service.AnimeService;
import com.animeinfo.api.controller.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${app.api.base}/anime")
public class AnimeController extends CrudController
        <Anime, AnimeDTO, Long, AnimeMapper, AnimeService>
{
}
