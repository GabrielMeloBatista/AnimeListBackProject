package com.animeinfo.animeInfo.service.impl;

import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.animeInfo.repository.AnimeRepository;
import com.animeinfo.animeInfo.service.AnimeService;
import com.animeinfo.api.model.IEntidade;
import com.animeinfo.api.service.BaseCrudService;
import com.animeinfo.api.service.CrudService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AnimeServiceImpl
        extends BaseCrudService<Anime, Long, AnimeRepository>
        implements AnimeService {
    @Override
    protected void prepararParaIncluir(Anime entidade) {

    }

    @Override
    protected void validarDados(Anime entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Anime entidade) {

    }
}
