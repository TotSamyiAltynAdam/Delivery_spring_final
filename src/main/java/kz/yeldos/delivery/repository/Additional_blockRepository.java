package kz.yeldos.delivery.repository;

import jakarta.transaction.Transactional;
import kz.yeldos.delivery.model.Additional_block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface Additional_blockRepository extends JpaRepository<Additional_block,Long> {
    List<Additional_block> findAllByDishId(Long id);
}
