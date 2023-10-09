package com.animeinfo.animeInfo.model;

import com.animeinfo.api.model.IEntidade;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Hibernate;

import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table( name = "TBL_PERSONAL_LIST")
public class PersonalList implements IEntidade<Long> {

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

    @ManyToOne()
    @JoinColumn(name = "id", referencedColumnName = "AnimeId")
    private Anime anime;

    @Column(name = "Watched")
    private Integer watched;

    @Column(name = "Score")
    private Integer score;

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
        PersonalList personalList = (PersonalList) o;
        return id != null && Objects.equals(id, personalList.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
