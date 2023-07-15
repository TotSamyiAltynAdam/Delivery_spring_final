package kz.yeldos.delivery.repository;

import jakarta.transaction.Transactional;
import kz.yeldos.delivery.model.Category;
import kz.yeldos.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
    List<Restaurant> findByCategoryListContaining(Category category);
}
