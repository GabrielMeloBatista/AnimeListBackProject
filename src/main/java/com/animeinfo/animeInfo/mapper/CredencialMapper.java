package com.animeinfo.animeInfo.mapper;

import com.animeinfo.animeInfo.model.Credencial;
import com.animeinfo.theapi.dto.CredencialDTO;
import com.animeinfo.theapi.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CredencialMapper extends BaseMapper<Credencial, CredencialDTO> {
}
