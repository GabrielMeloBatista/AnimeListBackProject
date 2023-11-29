package com.animeinfo.animeInfo.model;

import com.animeinfo.theapi.model.IEntidade;
import com.animeinfo.theapi.model.annotation.PkComposite;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Hibernate;

import java.time.LocalDate;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@PkComposite
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
    private Long id;

    @Column(name = ANIME_NAME, nullable = false)
    private String nome;

    @Column(name = "DataDeLancamento")
    private LocalDate dataLacamento;

    @Column(name = "TipoAnime", nullable = false)
    private String tipoAnime;

    @Column(name = "GeneroID", nullable = false)
    private String generoID;

    @Override
    public String getTabelaNome() {
        return "Anime";
    }

    @Override
    public String getIdHash() {
        return null;
    }

    @Override
    public Long getIdFromHash(String hash) {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Anime anime = (Anime) o;
        return id != null && Objects.equals(id, anime.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
