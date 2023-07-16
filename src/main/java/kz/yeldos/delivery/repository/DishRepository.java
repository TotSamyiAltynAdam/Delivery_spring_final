package kz.yeldos.delivery.repository;

import jakarta.transaction.Transactional;
import kz.yeldos.delivery.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface DishRepository extends JpaRepository<Dish,Long> {
    List<Dish> findAllByRestaurantId(Long id);
}
