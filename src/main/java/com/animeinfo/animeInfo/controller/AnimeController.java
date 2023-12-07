package com.animeinfo.animeInfo.controller;

import com.animeinfo.animeInfo.dto.AnimeDTO;
import com.animeinfo.animeInfo.exception.SistemaMessageCode;
import com.animeinfo.animeInfo.mapper.AnimeMapper;
import com.animeinfo.animeInfo.model.Anime;
import com.animeinfo.animeInfo.service.AnimeService;
import com.animeinfo.api.controller.CrudController;
import com.animeinfo.api.exception.BusinessException;
import com.animeinfo.api.exception.MessageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "${app.api.base}/anime")
public class AnimeController extends CrudController
        <Anime, AnimeDTO, Long, AnimeMapper, AnimeService>
{
    @Autowired
    AnimeMapper animeMapper;
    @GetMapping(path = "/search")
    @Operation(description = "Obter os dados completos de uma entidiade pelo id informado!", responses = {
            @ApiResponse(responseCode = "200", description = "Entidade encontrada",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
            @ApiResponse(responseCode = "404", description = "Registro não encontrado",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class))),
            @ApiResponse(responseCode = "403", description = "Acesso negado",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class))),
            @ApiResponse(responseCode = "500", description = "Se você viu isso, quer dizer que não deu certo, ou olhou o codigo :)🙂, espero que funcione 🙏",
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    public ResponseEntity<List<AnimeDTO>> searchBooks(@RequestParam String searchTerm) {
        List<Anime> entidade = this.service.search(searchTerm);
        if (Objects.isNull(entidade))
            throw new BusinessException(SistemaMessageCode.ERRO_REGISTRO_NAO_ENCONTRADO);
        return ResponseEntity.ok(animeMapper.toDTO(entidade));
    }
}
