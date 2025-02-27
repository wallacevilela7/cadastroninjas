package tech.wvs.cadastroninjas.dto;

public record NinjaDto(
        String name,
        String email,
        Integer age,
        String imgUrl,
        String rankingNinja,
        MissaoDto missao) {
}
