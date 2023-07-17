package kz.yeldos.delivery.repository;

import jakarta.transaction.Transactional;
import kz.yeldos.delivery.model.Additional_dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface Additional_dishRepository extends JpaRepository<Additional_dish,Long> {
    List<Additional_dish> findAllByAdditionalBlockId(Long id);
}
