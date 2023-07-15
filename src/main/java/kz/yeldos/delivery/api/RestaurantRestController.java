package kz.yeldos.delivery.api;

import kz.yeldos.delivery.dto.RestaurantDTO;
import kz.yeldos.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/restaurant")
public class RestaurantRestController {
    private final RestaurantService restaurantService;

    @GetMapping
    public List<RestaurantDTO> restaurantList(){
        return restaurantService.getRestaurants();
    }

    @GetMapping(value = "{id}")
    public RestaurantDTO getRestaurant(@PathVariable(name="id") Long id){
        return restaurantService.getRestaurant(id);
    }

    @PostMapping
    public RestaurantDTO addRestaurant(@RequestBody RestaurantDTO restaurant){
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping
    public RestaurantDTO updateRestaurant(@RequestBody RestaurantDTO restaurant){
        return restaurantService.updateRestaurant(restaurant);
    }

    @DeleteMapping(value = "{id}")
    public void deleteRestaurant(@PathVariable(name="id") Long id){
        restaurantService.deleteRestaurant(id);
    }
    @DeleteMapping(value="/category/{id}")
    public void deleteCategoryFromRestaurants(@PathVariable(name="id") Long id){
        restaurantService.deleteCategoryFromRestaurants(id);
    }
}
