package com.animeinfo.api.service;

import com.animeinfo.api.dto.CredencialDTO;
import com.animeinfo.api.dto.CredencialRegisterDTO;
import com.animeinfo.api.dto.UsuarioSenhaDTO;

public interface UserProviderService {
    CredencialDTO getCredentialByLogin(String username);
    CredencialDTO redefinirSenha(UsuarioSenhaDTO usuarioSenhaDTO);
    CredencialDTO getCredentialByEmail(String email);

    CredencialDTO register(CredencialRegisterDTO credencialRegisterDTO);
}
