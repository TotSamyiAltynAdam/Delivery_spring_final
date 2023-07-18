package kz.yeldos.delivery.repository;

import jakarta.transaction.Transactional;
import kz.yeldos.delivery.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface DishRepository extends JpaRepository<Dish,Long> {
    void deleteAllByRestaurantId(Long id);
    List<Dish> findAllByDishTypeId(Long id);
    List<Dish> findAllByRestaurantId(Long id);
    List<Dish> findAllByRestaurantIdAndDishType_Id(Long restaurantId,Long dishTypeId);
}
