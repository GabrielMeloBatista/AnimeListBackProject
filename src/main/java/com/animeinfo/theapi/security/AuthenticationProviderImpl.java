/*
 * AuthenticationProviderImpl.java
 * Copyright (c) UEG.
 *
 *
 *
 *
 */

package com.animeinfo.theapi.security;


import com.animeinfo.theapi.dto.CredencialDTO;
import com.animeinfo.theapi.exception.BusinessException;
import com.animeinfo.theapi.service.AuthService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Classe responsável por prover a instância de {@link Authentication} com as
 * credenciais do Usuário logado.
 *
 * @author UEG
 */
@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private AuthService authService;

    /**
     * @see AuthenticationProvider#getAuthentication(String)
     */
    @Override
    public Credential getAuthentication(final String accessToken) {
        CredencialDTO credencialDTO = null;

        try {
            credencialDTO = authService.getInfoByToken(accessToken);

        } catch (BusinessException e) {
            logger.error("Acesso negado.", e);
            throw e;
        }
        return credencialDTO;
    }

}
