package com.animeinfo.animeInfo.mapper;

import com.animeinfo.animeInfo.dto.PersonalListListaDTO;
import com.animeinfo.animeInfo.model.PersonalList;
import com.animeinfo.theapi.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonalListMapper extends BaseMapper<PersonalList, PersonalListListaDTO> {
}
