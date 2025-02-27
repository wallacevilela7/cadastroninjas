package tech.wvs.cadastroninjas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tech.wvs.cadastroninjas.entity.NinjaEntity;
import tech.wvs.cadastroninjas.service.NinjaService;

import java.util.List;

@Controller
@RequestMapping(path = "/ninjas/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/list")
    public String listNinjas(Model model) {
        List<NinjaEntity> ninjas = ninjaService.findAll();
        model.addAttribute("ninjas", ninjas);
        return "listarNinjas";
    }

}
