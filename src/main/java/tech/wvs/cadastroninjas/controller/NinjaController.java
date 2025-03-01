package tech.wvs.cadastroninjas.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.wvs.cadastroninjas.dto.NinjaDto;
import tech.wvs.cadastroninjas.entity.NinjaEntity;
import tech.wvs.cadastroninjas.service.NinjaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping
    @Operation(summary = "Cria um novo ninja",
            description = "Essa rota é responsável por criar um novo ninja")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Requisição inválida, não foi possível criar o ninja"),
    })
    public ResponseEntity<Void> createNinja(@Parameter(description = "Usuario envia os dados do ninja a ser atualiado no body da requisicao")
                                            @RequestBody NinjaDto dto) {
        var ninja = ninjaService.createNinja(dto);

        return ResponseEntity.created(URI.create("ninjas/" + ninja.getId())).build();
    }


    @GetMapping(path = "/{id}")
    @Operation(summary = "Buscar um ninja pelo Id",
            description = "Essa rota é responsável por buscar um ninja pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Ninja não encontrado"),
    })
    public ResponseEntity<NinjaEntity> getNinja(@PathVariable Long id) {
        var ninja = ninjaService.getNinja(id);

        return ninja.isPresent() ?
                ResponseEntity.ok(ninja.get()) :
                ResponseEntity.notFound().build();
    }

    @GetMapping
    @Operation(summary = "Listar todos os ninjas",
            description = "Essa rota é responsável por listar todos os ninjas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninjas encontrados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum ninja encontrado"),
    })
    public ResponseEntity<List<NinjaEntity>> findAll() {
        return ResponseEntity.ok(ninjaService.findAll());
    }


    @PutMapping(path = "/{id}")
    @Operation(summary = "Atualiza um ninja pelo Id",
            description = "Essa rota é responsável por atualizar um ninja pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Ninja atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Requisição inválida, não foi possível atualizar o ninja"),
    })
    public ResponseEntity<Void> updateNinja(@Parameter(description = "Usuario envia o id no path da requisicao")
                                            @PathVariable Long id,
                                            @Parameter(description = "Usuario envia os dados do ninja a ser atualiado no body da requisicao")
                                            @RequestBody NinjaDto dto) {
        var ninja = ninjaService.updateNinja(id, dto);

        return ninja.isPresent() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    @Operation(summary = "Deleta um ninja pelo Id",
            description = "Essa rota é responsável por deletar um ninja pelo Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Ninja deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Requisição inválida, não foi possível deletar o ninja"),
    })
    public ResponseEntity<Void> deleteNinja(@PathVariable Long id) {
        var deleted = ninjaService.deleteNinja(id);

        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
