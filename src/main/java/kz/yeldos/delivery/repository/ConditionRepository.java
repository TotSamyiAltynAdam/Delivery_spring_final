package kz.yeldos.delivery.repository;

import jakarta.transaction.Transactional;
import kz.yeldos.delivery.model.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ConditionRepository extends JpaRepository<Condition,Long> {
}
