package tech.wvs.cadastroninjas.controller;

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
    public ResponseEntity<Void> createNinja(@RequestBody NinjaDto dto){
        var ninja = ninjaService.createNinja(dto);

        return ResponseEntity.created(URI.create("ninjas/" + ninja.getId())).build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<NinjaEntity> getNinja(@PathVariable Long id){
        var ninja = ninjaService.getNinja(id);

        return ninja.isPresent() ?
                ResponseEntity.ok(ninja.get()) :
                ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<NinjaEntity>> findAll(){
        return ResponseEntity.ok(ninjaService.findAll());
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> updateNinja(@PathVariable Long id,
                                            @RequestBody NinjaDto dto){
        var ninja = ninjaService.updateNinja(id, dto);

        return ninja.isPresent() ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteNinja(@PathVariable Long id){
        var deleted =  ninjaService.deleteNinja(id);

        return deleted ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }
}
