package com.animeinfo.theapi.service;

import com.animeinfo.theapi.dto.AuthDTO;
import com.animeinfo.theapi.dto.CredencialDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserPasswordService {
    public static Boolean loginByPassword(CredencialDTO usuario, AuthDTO authDTO) {
        if (!authDTO.getLogin().equals(usuario.getLogin())) {
            return false;
        }
        // Tratamento de senha sem enconde (senha com menos de 21 caracteres
        if (usuario.getSenha().length() <= 20) {
            if (authDTO.getSenha().equals(usuario.getSenha())) {
                return true;
            }
        } else {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            if (bCryptPasswordEncoder.matches(authDTO.getSenha(), usuario.getSenha())) {
                return true;
            }
        }
        return false;
    }
}
