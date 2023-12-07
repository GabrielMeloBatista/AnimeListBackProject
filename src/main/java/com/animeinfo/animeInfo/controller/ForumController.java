package com.animeinfo.animeInfo.controller;

import com.animeinfo.animeInfo.dto.ForumDTO;
import com.animeinfo.animeInfo.mapper.ForumMapper;
import com.animeinfo.animeInfo.service.ForumService;
import com.animeinfo.api.controller.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${app.api.base}/forum")
public class ForumController extends CrudController
        <com.animeinfo.animeInfo.model.Forum, ForumDTO, Long, ForumMapper, ForumService>
{
}
