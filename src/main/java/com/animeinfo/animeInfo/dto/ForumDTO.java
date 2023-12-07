package com.animeinfo.animeInfo.dto;

import com.animeinfo.animeInfo.model.Anime;
import lombok.Data;

public @Data class ForumDTO {
    private Long id;
    private Anime anime;
    private Long score;
    private String shittyOpinions;
}
