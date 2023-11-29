package com.animeinfo.animeInfo.service.impl;

import com.animeinfo.animeInfo.model.Credencial;
import com.animeinfo.animeInfo.repository.CredencialRepository;
import com.animeinfo.animeInfo.service.CredentialService;
import com.animeinfo.theapi.service.BaseCrudService;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceImpl
        extends BaseCrudService<Credencial, Long, CredencialRepository>
        implements CredentialService {
    // TODO validação de usuario
    @Override
    protected void prepararParaIncluir(Credencial entidade) {

    }

    @Override
    protected void validarDados(Credencial entidade) {

    }

    @Override
    protected void validarCamposObrigatorios(Credencial entidade) {

    }
}
