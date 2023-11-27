package com.animeinfo.animeInfo.mapper;

import com.animeinfo.animeInfo.dto.ForumDTO;
import com.animeinfo.theapi.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ForumMapper extends BaseMapper<com.animeinfo.animeInfo.model.Forum, ForumDTO> {
}
