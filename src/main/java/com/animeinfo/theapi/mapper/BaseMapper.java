package com.animeinfo.theapi.mapper;

import java.util.List;

public interface BaseMapper<ENTIDADE, DTO> {
    ENTIDADE toModelo(DTO dto);
    DTO toDTO(ENTIDADE modelo);
    List<DTO> toDTO(List<ENTIDADE> lista);
}
