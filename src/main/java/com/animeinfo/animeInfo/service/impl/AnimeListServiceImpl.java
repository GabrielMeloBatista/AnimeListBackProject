package com.animeinfo.animeInfo.service.impl;

import com.animeinfo.animeInfo.model.AnimeList;
import com.animeinfo.animeInfo.repository.AnimeListRepository;
import com.animeinfo.animeInfo.service.AnimeListService;
import com.animeinfo.api.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class AnimeListServiceImpl
        extends BaseCrudService<AnimeList, Long, AnimeListRepository>
        implements AnimeListService {
    @Override
    protected void prepararParaIncluir(AnimeList entidade) {

    }

    @Override
    protected void validarDados(AnimeList entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(AnimeList entidade) {

    }
}
