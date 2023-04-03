package com.animeinfo.animeInfo.dto;

import lombok.Data;

import java.sql.Date;

public @Data class AnimeDTO {
    private long id;
    private String nome;
    private Date dataLacamento;
    private String tipoAnime;
    private String generoID;
}
