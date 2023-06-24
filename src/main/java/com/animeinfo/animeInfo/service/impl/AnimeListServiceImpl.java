package com.animeinfo.animeInfo.service.impl;

import com.animeinfo.animeInfo.exception.SistemaMessageCode;
import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.animeInfo.model.AnimeList;
import com.animeinfo.animeInfo.repository.AnimeListRepository;
import com.animeinfo.animeInfo.service.AnimeListService;
import com.animeinfo.api.exception.BusinessException;
import com.animeinfo.api.service.BaseCrudService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AnimeListServiceImpl
        extends BaseCrudService<AnimeList, Long, AnimeListRepository>
        implements AnimeListService {
    @Override
    protected void prepararParaIncluir(AnimeList entidade) {

    }

    @Override
    protected void validarDados(AnimeList entidade) {
        List<String> erros = new ArrayList<>();

        if (entidade.getWatched() < 0) {
            erros.add("Watched invalido");
        }

        if (entidade.getScore() < 0 || entidade.getScore() > 8){
            erros.add("Score invalido");
        }

        if(!erros.isEmpty()){
            throw  new BusinessException(SistemaMessageCode.MSG_OPERACAO_FRACASSADA_COM_SUCESSO);
        }
    }

    @Override
    protected void validarCamposObrigatorios(AnimeList entidade) {
        Anime anime = entidade.getAnime();

        if(Objects.isNull(entidade)){
            throw  new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }

        if(Objects.isNull(anime)){
            throw  new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }
    }
}
