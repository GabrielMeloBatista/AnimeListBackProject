package com.animeinfo.animeInfo.dto;

import lombok.Data;

import java.time.LocalDate;

public @Data class AnimeListaDTO {
    private Long id;
    private String nome;
    private LocalDate dataLacamento;
    private String tipoAnime;
    private String generoID;
}
