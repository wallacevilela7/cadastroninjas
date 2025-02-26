package tech.wvs.cadastroninjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.wvs.cadastroninjas.service.NinjaService;

@RestController
@RequestMapping(path = "/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping
    public String getNinjas() {
        return "Ninjas hello world";
    }
}
