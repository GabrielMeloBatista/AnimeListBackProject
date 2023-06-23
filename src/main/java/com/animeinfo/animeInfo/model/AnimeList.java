package com.animeinfo.animeInfo.model;

import com.animeinfo.api.model.IEntidade;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Hibernate;

import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table( name = "TBL_ANIME_LIST")
public class AnimeList implements IEntidade<Long> {
    public static final String UK_ANIME_NAME = "uk_anime_name";
    public static final String ANIME_NAME = "AnimeNome";

    @SequenceGenerator(
            name="al_gerador_sequence",
            sequenceName = "anime_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "al_gerador_sequence"
    )
    @Id
    @Column(name = "AnimeListId")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "AnimeId")
    private Anime anime;

    @Column(name = "Watched")
    private Integer watched;

    @Column(name = "Score")
    private Integer score;

    @Override
    public String getTabelaNome() {
        return "AnimeList";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AnimeList animeList = (AnimeList) o;
        return id != null && Objects.equals(id, animeList.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
