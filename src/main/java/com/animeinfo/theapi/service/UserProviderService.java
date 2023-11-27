package com.animeinfo.theapi.service;

import com.animeinfo.theapi.dto.CredencialDTO;
import com.animeinfo.theapi.dto.CredencialRegisterDTO;
import com.animeinfo.theapi.dto.UsuarioSenhaDTO;

public interface UserProviderService {
    CredencialDTO getCredentialByLogin(String username);
    CredencialDTO redefinirSenha(UsuarioSenhaDTO usuarioSenhaDTO);
    CredencialDTO getCredentialByEmail(String email);

    CredencialDTO register(CredencialRegisterDTO credencialRegisterDTO);
}
