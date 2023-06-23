package com.animeinfo.animeInfo.mapper;

import com.animeinfo.animeInfo.dto.AnimeListDTO;
import com.animeinfo.animeInfo.model.AnimeList;
import com.animeinfo.api.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimeListMapper extends BaseMapper<AnimeList, AnimeListDTO> {
}
