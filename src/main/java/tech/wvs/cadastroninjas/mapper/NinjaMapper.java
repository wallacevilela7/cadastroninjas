package tech.wvs.cadastroninjas.mapper;

import tech.wvs.cadastroninjas.dto.NinjaDto;
import tech.wvs.cadastroninjas.entity.NinjaEntity;

public class NinjaMapper {
    public NinjaEntity toEntity(NinjaDto dto){
        var ninja = new NinjaEntity();
        ninja.setName(dto.name());
        ninja.setEmail(dto.email());
        ninja.setAge(dto.age());
        ninja.setImgUrl(dto.imgUrl());
        ninja.setRankingNinja(dto.rankingNinja());
        return ninja;
    }

    public NinjaDto toDto(NinjaEntity entity){
        return new NinjaDto(
                entity.getName(),
                entity.getEmail(),
                entity.getAge(),
                entity.getImgUrl(),
                entity.getRankingNinja()
        );
    }
}
