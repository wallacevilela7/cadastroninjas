package tech.wvs.cadastroninjas.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_ninjas")
public class NinjaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "ranking_ninja")
    private String rankingNinja;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private MissaoEntity missao;

    public NinjaEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRankingNinja() {
        return rankingNinja;
    }

    public void setRankingNinja(String rankingNinja) {
        this.rankingNinja = rankingNinja;
    }

    public MissaoEntity getMissao() {
        return missao;
    }

    public void setMissao(MissaoEntity missao) {
        this.missao = missao;
    }
}
