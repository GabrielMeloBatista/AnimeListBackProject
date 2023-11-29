package com.animeinfo.animeInfo.model;

import com.animeinfo.theapi.model.IEntidade;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Hibernate;

import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table( name = "TBL_FORUM")
public class Forum implements IEntidade<Long> {
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
    @Column(name = "ForumId")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id", referencedColumnName = "AnimeId")
    private Anime anime;

    @Column(name = "ShittyOpinions")
    private String shittyOpinions;

    @Override
    public String getTabelaNome() {
        return "Forum";
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
        Forum forum = (Forum) o;
        return id != null && Objects.equals(id, forum.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
