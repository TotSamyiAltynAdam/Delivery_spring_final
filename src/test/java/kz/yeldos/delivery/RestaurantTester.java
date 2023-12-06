package kz.yeldos.delivery;

import kz.yeldos.delivery.dto.RestaurantDTO;
import kz.yeldos.delivery.mapper.RestaurantMapper;
import kz.yeldos.delivery.model.Category;
import kz.yeldos.delivery.model.Restaurant;
import kz.yeldos.delivery.service.RestaurantService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class RestaurantTester {
    @Autowired
    private RestaurantMapper restaurantMapper;

    @Test
    void checkRestaurantDTO(){
        Restaurant restaurant = getRestaurant();

        RestaurantDTO restaurantDTO = restaurantMapper.toDto(restaurant);

        Assertions.assertEquals(restaurant.getId(), restaurantDTO.getId());
        Assertions.assertEquals(restaurant.getName(), restaurantDTO.getName());
        Assertions.assertEquals(restaurant.getRatings(), restaurantDTO.getRatings());
        Assertions.assertEquals(restaurant.getAddress(), restaurantDTO.getAddress());
        Assertions.assertEquals(restaurant.getPhoto(), restaurantDTO.getPhoto());
        Assertions.assertEquals(restaurant.getCategoryList().size(),restaurantDTO.getCategories().size());
        Assertions.assertEquals(restaurant.getUserEmail(), restaurantDTO.getUserEmail());
    }


    private static Restaurant getRestaurant() {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(17L);
        restaurant.setName("DOS_RESTAURANT");
        restaurant.setAddress("Shymkent");
        restaurant.setRatings(99);
        restaurant.setPhoto("/media/dbImages/baurdaq.png");

        List<Category> categoryList = new ArrayList<>();
        Category category1 = new Category();
        category1.setName("Kazakh");
        categoryList.add(category1);

        restaurant.setCategoryList(categoryList);
        restaurant.setUserEmail("eldosanarbaev7@gmail.com");
        return restaurant;
    }

}
