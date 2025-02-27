package tech.wvs.cadastroninjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.wvs.cadastroninjas.entity.MissaoEntity;

public interface MissaoRepository extends JpaRepository<MissaoEntity, Long> {
}
