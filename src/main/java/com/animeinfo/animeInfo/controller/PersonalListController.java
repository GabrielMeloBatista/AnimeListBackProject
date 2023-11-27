package com.animeinfo.animeInfo.controller;

import com.animeinfo.animeInfo.dto.PersonalListListaDTO;
import com.animeinfo.animeInfo.mapper.PersonalListMapper;
import com.animeinfo.animeInfo.service.PersonalListService;
import com.animeinfo.theapi.controller.CrudController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "${app.api.base}/PersonalList")
public class PersonalListController extends CrudController
        <com.animeinfo.animeInfo.model.PersonalList, PersonalListListaDTO, Long, PersonalListMapper, PersonalListService>
{
}
