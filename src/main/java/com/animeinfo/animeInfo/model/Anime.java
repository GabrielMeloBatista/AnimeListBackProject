package com.animeinfo.animeInfo.model;

import com.animeinfo.api.model.IEntidade;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table( name = "TBL_ANIME",
        uniqueConstraints = {
                @UniqueConstraint(name= Anime.UK_ANIME_NAME, columnNames = Anime.ANIME_NAME )
        }
)
public class Anime implements IEntidade<Long> {
    public static final String UK_ANIME_NAME = "uk_anime_name";
    public static final String ANIME_NAME = "nome";
    @SequenceGenerator(
            name="a_gerador_sequence",
            sequenceName = "anime_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "a_gerador_sequence"
    )
    @Id
    @Column(name = "AnimeId")
    private long id;

    @Column(name = ANIME_NAME, nullable = false)
    private String nome;

    @Column(name = "DataDeLancamento")
    private Date dataLacamento;

    @Column(name = "TipoAnime", nullable = false)
    private String tipoAnime;

    @Column(name = "GeneroID", nullable = false)
    private String generoID;

    @Override
    public String getTabelaNome() {
        return "Anime";
    }
}
