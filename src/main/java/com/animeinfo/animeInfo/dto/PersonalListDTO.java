package com.animeinfo.animeInfo.dto;

import com.animeinfo.animeInfo.model.Anime;
import lombok.Data;

public @Data class PersonalListDTO {
    private Long id;
    private Anime anime;
    private Integer watched;
    private Integer score;
}
