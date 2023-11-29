package com.animeinfo.theapi.security;/*
 * AuthenticationProvider.java
 * Copyright (c) UEG.
 *
 *
 *
 *
 */


import org.springframework.security.core.Authentication;

/**
 * Classe responsável por prover a instância de {@link Authentication} com as
 * credenciais do Usuário logado.
 *
 * @author UEG.
 */
public interface AuthenticationProvider {

    /**
     * Retorna a instância de {@link Credential} conforme as informações recuperadas
     * através do 'token' informado.
     *
     * @param token
     * @return
     */
    public Credential getAuthentication(final String token);
}