package com.animeinfo.animeInfo.model;

import jakarta.persistence.*;
import lombok.Data;


import java.sql.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table( name = "TBL_ANIME",
        uniqueConstraints = {
                @UniqueConstraint(name= Anime.UK_ANIME_NAME, columnNames = "nome" )
        }
)
public class Anime {
    public static final String UK_ANIME_NAME = "uk_anime_name";
    @SequenceGenerator(
        name = "a_generator_sequence",
        sequenceName = "anime_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = SEQUENCE,
        generator = "a_generator_sequence"
    )
    @Id
    @Column(name = "AnimeId")
    private long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "DataDeLancamento")
    private Date dataLacamento;

    @Column(name = "TipoAnime", nullable = false)
    private String tipoAnime;

    @Column(name = "GeneroID", nullable = false)
    private String generoID;
}
