package tech.wvs.cadastroninjas.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long missaoId;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private String level;

    @OneToMany(mappedBy = "missao", fetch = FetchType.EAGER)
    private List<NinjaEntity> ninjas;

    public MissaoEntity() {
    }

    public Long getMissaoId() {
        return missaoId;
    }

    public void setMissaoId(Long id) {
        this.missaoId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MissaoEntity{");
        sb.append("level='").append(level).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", missaoId=").append(missaoId);
        sb.append('}');
        return sb.toString();
    }
}
