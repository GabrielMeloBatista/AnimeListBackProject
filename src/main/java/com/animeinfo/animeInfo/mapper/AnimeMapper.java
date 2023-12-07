package com.animeinfo.animeInfo.mapper;

import com.animeinfo.animeInfo.dto.AnimeDTO;
import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.api.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnimeMapper extends BaseMapper<Anime, AnimeDTO> {
}
