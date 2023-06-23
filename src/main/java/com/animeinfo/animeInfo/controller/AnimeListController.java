package com.animeinfo.animeInfo.controller;

import com.animeinfo.animeInfo.dto.AnimeListDTO;
import com.animeinfo.animeInfo.mapper.AnimeListMapper;
import com.animeinfo.animeInfo.model.AnimeList;
import com.animeinfo.animeInfo.service.AnimeListService;
import com.animeinfo.api.controller.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${app.api.base}/animeList")
public class AnimeListController extends CrudController
        <AnimeList, AnimeListDTO, Long, AnimeListMapper, AnimeListService>
{
}
