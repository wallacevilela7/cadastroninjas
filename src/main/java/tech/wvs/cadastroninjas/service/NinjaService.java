package tech.wvs.cadastroninjas.service;

import org.springframework.stereotype.Service;
import tech.wvs.cadastroninjas.dto.NinjaDto;
import tech.wvs.cadastroninjas.entity.MissaoEntity;
import tech.wvs.cadastroninjas.entity.NinjaEntity;
import tech.wvs.cadastroninjas.repository.MissaoRepository;
import tech.wvs.cadastroninjas.repository.NinjaRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.hasText;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final MissaoRepository missaoRepository;

    public NinjaService(NinjaRepository ninjaRepository, MissaoRepository missaoRepository) {
        this.ninjaRepository = ninjaRepository;
        this.missaoRepository = missaoRepository;
    }

    public NinjaEntity createNinja(NinjaDto dto) {
        var missao = new MissaoEntity();
        missao.setName(dto.missao().name());
        missao.setLevel(dto.missao().level());

        missaoRepository.save(missao);

        var ninja = new NinjaEntity();
        ninja.setName(dto.name());
        ninja.setEmail(dto.email());
        ninja.setAge(dto.age());
        ninja.setImgUrl(dto.imgUrl());
        ninja.setRankingNinja(dto.rankingNinja());
        ninja.setMissao(missao);

        return ninjaRepository.save(ninja);
    }

    public Optional<NinjaEntity> getNinja(Long id) {
        return ninjaRepository.findById(id);
    }

    public List<NinjaEntity> findAll() {
        return ninjaRepository.findAll();
    }

    public Optional<NinjaEntity> updateNinja(Long id, NinjaDto dto) {
        var ninja = ninjaRepository.findById(id);

        if(ninja.isPresent()){
            updateFields(dto, ninja);
            ninjaRepository.save(ninja.get());
        }
        return ninja;
    }

    private void updateFields(NinjaDto dto, Optional<NinjaEntity> ninja) {
        if(hasText(dto.name())) {
            ninja.get().setName(dto.name());
        }

        if(hasText(dto.email())) {
            ninja.get().setEmail(dto.email());
        }

        if(dto.age() != null) {
            ninja.get().setAge(dto.age());
        }

        if(hasText(dto.imgUrl())) {
            ninja.get().setImgUrl(dto.imgUrl());
        }

        if(hasText(dto.rankingNinja())) {
            ninja.get().setRankingNinja(dto.rankingNinja());
        }

        if(dto.missao() != null) {
            var missao = new MissaoEntity();
            missao.setName(dto.missao().name());
            missao.setLevel(dto.missao().level());

            missaoRepository.save(missao);

            ninja.get().setMissao(missao);
        }
    }

    public boolean deleteNinja(Long id) {
        var exists = ninjaRepository.existsById(id);

        if(exists){
            ninjaRepository.deleteById(id);
        }

        return exists;
    }
}
