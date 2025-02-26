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

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

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

    public void setIdade(Integer age) {
        this.age = this.age;
    }
}
