package com.animeinfo.animeInfo.dto;

import com.animeinfo.animeInfo.model.Anime;
import lombok.Data;

public @Data class AnimeListListaDTO {
    private Integer score;
    private Anime anime;
    private Integer watched;
}
