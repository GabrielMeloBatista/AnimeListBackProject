package com.animeinfo.animeInfo.dto;

import lombok.Data;

import java.time.LocalDate;

public @Data class AnimeDTO {
    private long id;
    private String nome;
    private LocalDate dataLacamento;
    private String generoID;
    private String tipoAnime;
}
