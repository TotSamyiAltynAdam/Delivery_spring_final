package kz.yeldos.delivery.api;

import kz.yeldos.delivery.model.Restaurant;
import kz.yeldos.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/api/restaurant")
public class RestaurantRestController {
    private final RestaurantService restaurantService;

    @GetMapping(value = "/get-restaurant-list")
    public List<Restaurant> getRestaurants(){
        return restaurantService.getRestaurants();
    }
}
