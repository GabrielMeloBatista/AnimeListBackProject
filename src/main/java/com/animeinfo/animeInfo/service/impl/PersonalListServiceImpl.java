package com.animeinfo.animeInfo.service.impl;

import com.animeinfo.animeInfo.model.PersonalList;
import com.animeinfo.animeInfo.repository.PersonalListRepository;
import com.animeinfo.animeInfo.service.PersonalListService;
import com.animeinfo.api.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class PersonalListServiceImpl extends BaseCrudService<PersonalList, Long, PersonalListRepository>
        implements PersonalListService {
    @Override
    protected void prepararParaIncluir(PersonalList entidade) {

    }

    @Override
    protected void validarDados(PersonalList entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(PersonalList entidade) {

    }
}
