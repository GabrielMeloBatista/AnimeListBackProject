package com.animeinfo.animeInfo.controller;

import com.animeinfo.animeInfo.dto.AnimeDTO;
import com.animeinfo.animeInfo.dto.AnimeListaDTO;
import com.animeinfo.animeInfo.dto.AnimeDadosAlteravelDTO;
import com.animeinfo.animeInfo.mapper.AnimeMapper;
import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.animeInfo.service.AnimeService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "${app.api.base}/anime")
public class AnimeController {
    @Autowired
    private AnimeMapper animeMapper;

    @Autowired
    private AnimeService animeService;

    @GetMapping()
    @Operation(description = "Listagem Geral de animes")
    public List<AnimeListaDTO> listAll(){
        List<Anime> animes = animeService.listarTodos();
        /*var listaDeAlunos =
                animes.stream()
                        .filter ( item -> Objects.nonNull(item.getEMail()) )
                        .map    ( item -> alunoMapper.toDTO(item) )
                        .collect(Collectors.toList());*/
        return animeMapper.toDTO(animes);
    }

    @PostMapping
    @Operation(description = "Método utilizado para realizar a inclusão de um anime")
    public AnimeDTO incluir(@RequestBody AnimeDadosAlteravelDTO anime){
        //prepração para entrada.
        Anime animeIncluir = this.animeMapper.toModelo(anime);

        //chamada do serviço
        System.out.println(animeIncluir);
        animeIncluir = this.animeService.incluir(animeIncluir);

        //preparação para o retorno
        return this.animeMapper.toAlunoDTO(animeIncluir);
    }

    @PutMapping(path = "/{id}")
    @Operation(description = "Método utilizado para alterar os dados de um anime")
    public AnimeDTO alterar(@RequestBody() AnimeDadosAlteravelDTO anime, @PathVariable(name = "id") Long cadastro ){
        Anime pAnime = animeMapper.toModelo(anime);
        Anime alterar = animeService.alterar(pAnime, cadastro);
        return animeMapper.toAlunoDTO(alterar);
    }
    @DeleteMapping(path ="/{id}")
    @Operation(description = "Método utililzado para remover um anime pela cadastro informada")
    public AnimeDTO remover(@PathVariable(name = "id") Long id){
        Anime animeExcluido = this.animeService.excluir(id);
        return animeMapper.toAlunoDTO(animeExcluido);
    }

    @GetMapping(path = "/{id}")
    @Operation(description = "Obter os dados completos de um aluno pela matricula(id) informado!")
    public AnimeDTO ObterPorId(@PathVariable(name = "id") Long id){
        Anime anime = this.animeService.obterAnimePorID(id);
        return this.animeMapper.toAlunoDTO(anime);
    }

    @PostMapping(path = "/pesquisar")
    @Operation(description = "Busca alunos pelos dados informados")
    public List<AnimeListaDTO> pesquisar(
            @RequestBody AnimeDTO anime
    ){
        Anime animeBusca = this.animeMapper.toModelo(anime);
        List<Anime> localizar = animeService.localizar(animeBusca);
        return this.animeMapper.toDTO(localizar);
    }
}
