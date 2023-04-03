package com.animeinfo.animeInfo.service;

import com.animeinfo.animeInfo.model.Anime;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AnimeService {
    public Anime incluir(Anime anime);
    public Anime alterar(Anime anime, Long matricula);
    public Anime excluir(long matricula);
    public Anime obterAnimePorID(Long id);
    public List<Anime> listarTodos();
    public List<Anime> localizar(Anime anime);
}
