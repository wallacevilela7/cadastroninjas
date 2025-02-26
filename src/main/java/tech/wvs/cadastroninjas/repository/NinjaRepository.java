package tech.wvs.cadastroninjas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.wvs.cadastroninjas.entity.NinjaEntity;

public interface NinjaRepository extends JpaRepository<NinjaEntity, Long> {
}
