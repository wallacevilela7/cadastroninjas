package tech.wvs.cadastroninjas.service;

import org.springframework.stereotype.Service;
import tech.wvs.cadastroninjas.repository.NinjaRepository;

@Service
public class NinjaService {

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    private final NinjaRepository ninjaRepository;
}
