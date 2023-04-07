package com.animeinfo.animeInfo.mapper;

import com.animeinfo.animeInfo.dto.AnimeDTO;
import com.animeinfo.animeInfo.dto.AnimeDadosAlteravelDTO;
import com.animeinfo.animeInfo.dto.AnimeListaDTO;
import com.animeinfo.animeInfo.model.Anime;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimeMapper {

    /**
     * Converte a Entidade {@link Anime} em {@link AnimeListaDTO}
     * @param anime
     * @return
     */
    public AnimeDTO toDTO(Anime anime);

    public List<AnimeListaDTO> toDTO(List<Anime> animes);

    public AnimeDadosAlteravelDTO toAlunoIncluirDTO(Anime anime);

    public Anime toModelo(AnimeDadosAlteravelDTO anime);

    public AnimeDTO toAlunoDTO(Anime aluno);

    public Anime toModelo(AnimeDTO aluno);
}
