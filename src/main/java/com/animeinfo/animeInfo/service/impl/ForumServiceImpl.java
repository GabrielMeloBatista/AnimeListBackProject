package com.animeinfo.animeInfo.service.impl;

import com.animeinfo.animeInfo.exception.SistemaMessageCode;
import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.animeInfo.model.Forum;
import com.animeinfo.animeInfo.repository.ForumRepository;
import com.animeinfo.animeInfo.service.ForumService;
import com.animeinfo.theapi.exception.BusinessException;
import com.animeinfo.theapi.service.BaseCrudService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ForumServiceImpl
        extends BaseCrudService<Forum, Long, ForumRepository>
        implements ForumService {
    @Override
    protected void prepararParaIncluir(Forum entidade) {

    }

    @Override
    protected void validarDados(Forum entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Forum entidade) {
        Anime anime = entidade.getAnime();

        if(Objects.isNull(anime)){
            throw  new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
        }
    }
}
