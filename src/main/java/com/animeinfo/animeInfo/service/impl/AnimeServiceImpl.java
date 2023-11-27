package com.animeinfo.animeInfo.service.impl;

import com.animeinfo.animeInfo.exception.SistemaMessageCode;
import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.animeInfo.repository.AnimeRepository;
import com.animeinfo.animeInfo.service.AnimeService;
import com.animeinfo.theapi.exception.BusinessException;
import com.animeinfo.theapi.service.BaseCrudService;
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
        List<String> erros = new ArrayList<>();

        if (entidade.getGeneroID().isEmpty()) {
            erros.add("Genero não pode ser vazio");
        }

        if (entidade.getTipoAnime().isEmpty()) {
            erros.add("Tipo não pode ser vazio");
        }

        if (!erros.isEmpty()) {
            throw new BusinessException(SistemaMessageCode.MSG_OPERACAO_FRACASSADA_COM_SUCESSO);
        }
    }

    @Override
    protected void validarCamposObrigatorios(Anime entidade) {
        if (Objects.isNull(entidade)) {
            throw new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }
    }
}
