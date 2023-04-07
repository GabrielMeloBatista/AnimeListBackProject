package com.animeinfo.animeInfo.repository.impl;

import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.animeInfo.repository.AnimeRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AnimeRepositoryImpl implements AnimeRepositoryCustom {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Anime> localizarPorAnime(Anime anime) {
        Map<String, Object> parametros = new HashMap<>();
        StringBuilder jpql = new StringBuilder();
        jpql.append(" SELECT anime FROM Anime anime");

        jpql.append(" WHERE 1=1 ");

        if (Strings.isNotEmpty(anime.getNome())) {
            jpql.append(" AND UPPER(anime.nome) LIKE UPPER('%' || :nome || '%')  ");
            parametros.put("nome", anime.getNome());
        }
        if (Strings.isNotEmpty(anime.getGeneroID())) {
            jpql.append(" AND UPPER(anime.GeneroID) LIKE UPPER('%' || :genero_id || '%')  ");
            parametros.put("genero_id", anime.getGeneroID());
        }
        if(Objects.nonNull(anime.getTipoAnime())){
            jpql.append(" AND anime.TipoAnime = LIKE UPPER('%' || :tipo_anime || '%')  ");
            parametros.put("tipo_anime", anime.getTipoAnime());
        }
        if(Objects.nonNull(anime.getDataLacamento())){
            jpql.append(" AND anime.getDataLacamento = UPPER('%' || :data_lancamento || '%')  ");
            parametros.put("data_lancamento", anime.getDataLacamento());
        }

        TypedQuery<Anime> query = entityManager.createQuery(jpql.toString(), Anime.class);
        parametros.entrySet().forEach(parametro -> query.setParameter(parametro.getKey(), parametro.getValue()));

        return query.getResultList();
    }
}
