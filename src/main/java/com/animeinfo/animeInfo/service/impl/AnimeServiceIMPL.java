package com.animeinfo.animeInfo.service.impl;

import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.animeInfo.repository.AnimeRepository;
import com.animeinfo.animeInfo.service.AnimeService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AnimeServiceIMPL implements AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public Anime incluir(Anime anime) {
        this.validarCamposObrigatorios(anime);
        this.validarDados(anime);
        this.prepararParaIncluir(anime);
        return this.gravarDados(anime);
    }

    private Anime prepararParaIncluir(Anime anime)
    {
        return animeRepository.save(anime);
    }


    private Anime gravarDados(Anime anime) {
        return animeRepository.save(anime);
    }

    private void validarDados(Anime anime) {
        List<String> erros = new ArrayList<>();

        /*if(!ValidacoesComum.isEmailValido(anime.getEMail())){
            erros.add("E-mail inválido");
        }

        String validacaoEmail = validarEmailExistente(aluno);
        if(Strings.isNotEmpty(validacaoEmail)){
            erros.add(validacaoEmail);
        }

        if(!erros.isEmpty()){
            throw  new IllegalArgumentException("Erro ao Validar dados do Aluno: "+
                    String.join(",", erros)
            );
        }*/
    }

    private void validarCamposObrigatorios(Anime anime) {
        if(Objects.isNull(anime)){
            throw  new IllegalArgumentException("Entidiade Aluno deve ser preenchida");
        }
        List<String> camposVazios = new ArrayList<>();
        if(Strings.isEmpty(anime.getNome())){
            camposVazios.add("Primeiro Nome");
        }
        if(Strings.isEmpty(anime.getTipoAnime())){
            camposVazios.add("Segundo Nome");
        }
        if(Strings.isEmpty(anime.getGeneroID())){
            camposVazios.add("Segundo Nome");
        }
        if(!camposVazios.isEmpty()) {
            throw  new IllegalArgumentException(
                    "Campos Obrigatórios não preenchidos ("+
                            String.join(",",camposVazios)+")"
            );
        }
    }

    @Override
    public Anime alterar(Anime anime, Long cadastro) {
        this.validarCamposObrigatorios(anime);
        this.validarDados(anime);

        anime.setId(cadastro);

        anime.setId(cadastro);

        Anime save = animeRepository.save(anime);

        return save;
    }

    private Anime recuperarAnimeOuGeraErro(Long cadastro) {
        Anime animeBD = animeRepository
                .findById(cadastro)
                .orElseThrow(
                        () -> new IllegalArgumentException("Erro ao Localizar o anime!")
                );
        return animeBD;
    }

    @Override
    public Anime excluir(long id) {
        Anime animeExcluir = this.recuperarAnimeOuGeraErro(id);
        this.animeRepository.delete(animeExcluir);
        return animeExcluir;
    }

    @Override
    public Anime obterAnimePorID(Long id) {
        return recuperarAnimeOuGeraErro(id);
    }

    @Override
    public List<Anime> listarTodos() {
        return animeRepository.findAll();
    }

    @Override
    public List<Anime> localizar(Anime anime) {
        return animeRepository.localizarPorAnime(anime);
    }
}
