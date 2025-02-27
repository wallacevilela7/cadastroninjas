package tech.wvs.cadastroninjas.dto;

public record NinjaDto(
        String name,
        String email,
        Integer age,
        String imgUrl,
        String rankingNinja
) {

    public NinjaDto(String name, String email, Integer age, String imgUrl, String rankingNinja) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.imgUrl = imgUrl;
        this.rankingNinja = rankingNinja;
    }
}
