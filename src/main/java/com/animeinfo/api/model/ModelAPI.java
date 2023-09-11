package com.animeinfo.api.model;

import com.animeinfo.animeInfo.exception.SistemaMessageCode;
import com.animeinfo.api.exception.BusinessException;

import java.lang.reflect.Field;

public abstract class ModelAPI {
    public static void validarCamposObrigatorios(Class<?> classe) {
        // Obter todos os campos declarados na classe
        Field[] campos = classe.getDeclaredFields();

        for (Field campo : campos) {
            // Verificar se o campo está marcado com a anotação @DataModel
            if (campo.isAnnotationPresent(DataModel.class)) {
                DataModel dataModelAnnotation = campo.getAnnotation(DataModel.class);
                boolean isObrigatory = dataModelAnnotation.isObrigatory();

                campo.setAccessible(true);
                try {
                    Object valorCampo = campo.get(classe);

                    if (isObrigatory && valorCampo == null) {
                        throw new BusinessException(SistemaMessageCode.ERRO_CAMPOS_OBRIGATORIOS);
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
