package com.animeinfo.animeInfo.dto;

import lombok.Data;

import java.sql.Date;

public @Data class AnimeListaDTO {
    private Long id;
    private String nome;
    private Date dataLacamento;
    private String tipoAnime;
    private String generoID;
}
