package tech.wvs.cadastroninjas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ninjas")
public class NinjaController {

    @GetMapping
    public String getNinjas() {
        return "Ninjas hello world";
    }
}
