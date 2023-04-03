package com.animeinfo.animeInfo.repository;

import com.animeinfo.animeInfo.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long>, AnimeRepositoryCustom {
    Optional<Anime> findAnimeByNome(String nome);

    @Query(value = "select count(a) from Anime a where a.nome=:paramNome")
    Integer countUtilizacaoNome(String paramNome);
}
