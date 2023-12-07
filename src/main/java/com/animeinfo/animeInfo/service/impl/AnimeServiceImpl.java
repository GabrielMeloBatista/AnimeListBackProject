package com.animeinfo.animeInfo.service.impl;

import com.animeinfo.animeInfo.dto.AnimeDTO;
import com.animeinfo.animeInfo.exception.SistemaMessageCode;
import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.animeInfo.repository.AnimeRepository;
import com.animeinfo.animeInfo.service.AnimeService;
import com.animeinfo.api.exception.BusinessException;
import com.animeinfo.api.service.BaseCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AnimeServiceImpl
        extends BaseCrudService<Anime, Long, AnimeRepository>
        implements AnimeService {

    @Autowired
    AnimeRepository animeRepository;

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

    @Override
    public List<Anime> search(String searchTerm) {
        AnimeDTO animeDTO = new AnimeDTO();
        animeDTO.setNome(searchTerm);
        List<Anime> anime = repository.findAnimeByNomeContaining(searchTerm);
        if (Objects.isNull(anime)) {
            throw new BusinessException(SistemaMessageCode.ERRO_REGISTRO_NAO_ENCONTRADO);
        }
        return anime;
    }
}
