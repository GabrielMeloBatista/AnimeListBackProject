package com.animeinfo.animeInfo.service.impl;

import com.animeinfo.animeInfo.mapper.CredencialMapper;
import com.animeinfo.animeInfo.model.Credencial;
import com.animeinfo.animeInfo.service.CredentialService;
import com.animeinfo.api.dto.CredencialDTO;
import com.animeinfo.api.dto.CredencialRegisterDTO;
import com.animeinfo.api.dto.UsuarioSenhaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserProviderService implements com.animeinfo.api.service.UserProviderService {
    @Autowired
    private CredentialService credentialService;

    @Autowired
    private CredencialMapper credencialMapper;

    @Override
    public CredencialDTO getCredentialByLogin(String username) {
        System.out.println(username);
        if (Objects.nonNull(username)) {
            if (username.equals("admin")) {
                return getAdminCredencialDTO();
            }
            else {
                List<Credencial> credencial = credentialService.listarTodos();
                for (Credencial user: credencial) {
                    if (user.getLogin().equals(username)) {
                        return credencialMapper.toDTO(user);
                    }
                }
            }
        }

        return null;
    }

    private static CredencialDTO getAdminCredencialDTO() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senhaCodificada = bCryptPasswordEncoder.encode("admin");
        return CredencialDTO.builder()
                .login("admin")
                .id(1L)
                .nome("Admin")
                .email("admin@admin.com.br")
                .roles(Arrays.asList("ROLE_ADMIN", "ROLE_TIPO_INCLUIR"))
                .statusAtivo(true)
                .senha(senhaCodificada)
                .build();
    }

    private static CredencialDTO getCredencialDTOByUser(String user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senhaCodificada = bCryptPasswordEncoder.encode("password");
        return CredencialDTO.builder()
                .login("user")
                .id(1L)
                .nome("Admin")
                .email("admin@admin.com.br")
                .roles(Arrays.asList("ROLE_ADMIN", "ROLE_TIPO_INCLUIR"))
                .statusAtivo(true)
                .senha(senhaCodificada)
                .build();
    }

    @Override
    public CredencialDTO redefinirSenha(UsuarioSenhaDTO usuarioSenhaDTO) {
        return null;
    }

    @Override
    public CredencialDTO getCredentialByEmail(String email) {
        if (Objects.nonNull(email)) {
            if (email.equals("admin@admin.com.br")) {
                return getAdminCredencialDTO();
            }
            else {
                List<Credencial> credencial = credentialService.listarTodos();
                for (Credencial user: credencial) {
                    if (user.getEmail().equals(email)) {
                        return credencialMapper.toDTO(user);
                    }
                }
            }
        }
        return null;
    }

    @Override
    public CredencialDTO register(CredencialRegisterDTO credencialRegisterDTO) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senhaCodificada = bCryptPasswordEncoder.encode(credencialRegisterDTO.getSenha());
        CredencialDTO user = CredencialDTO.builder()
                .login(credencialRegisterDTO.getLogin())
                .id(credencialRegisterDTO.getId())
                .nome(credencialRegisterDTO.getNome())
                .email(credencialRegisterDTO.getEmail())
                .roles(Arrays.asList("ROLE_USER", "ROLE_TIPO_INCLUIR"))
                .statusAtivo(credencialRegisterDTO.isStatusAtivo())
                .senha(senhaCodificada)
                .build();
        Credencial credencial = credencialMapper.toModelo(user);
        credentialService.incluir(credencial);
        return user;
    }
}
