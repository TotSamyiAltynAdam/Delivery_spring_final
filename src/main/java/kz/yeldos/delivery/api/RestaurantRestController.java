package kz.yeldos.delivery.api;

import kz.yeldos.delivery.dto.Additional_blockDTO;
import kz.yeldos.delivery.dto.DishDTO;
import kz.yeldos.delivery.dto.RestaurantDTO;
import kz.yeldos.delivery.service.Additional_blockService;
import kz.yeldos.delivery.service.Additional_dishService;
import kz.yeldos.delivery.service.DishService;
import kz.yeldos.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/restaurant")
public class RestaurantRestController {
    private final RestaurantService restaurantService;
    private final DishService dishService;
    private final Additional_blockService additionalBlockService;
    private final Additional_dishService additionalDishService;

    @GetMapping
    public List<RestaurantDTO> restaurantList(){
        return restaurantService.getRestaurants();
    }

    @GetMapping(value = "{id}")
    public RestaurantDTO getRestaurant(@PathVariable(name="id") Long id){
        return restaurantService.getRestaurant(id);
    }
    @GetMapping(value="/email/{email}")
    public RestaurantDTO getRestaurantByEmail(@PathVariable(name="email") String email){
        return restaurantService.getRestaurantByEmail(email);
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
    public void deleteRestaurant(@PathVariable(name="id") Long resaurantId){
        List<DishDTO> dishDTOList = dishService.findDishesWhereRestaurant(resaurantId);
        for(DishDTO dishDTO: dishDTOList){
            List<Additional_blockDTO> additionalBlockDTOList = additionalBlockService.getAdditionalBlocksRelatedToTheParticularDish(dishDTO.getId());
            for (Additional_blockDTO additionalBlockDTO : additionalBlockDTOList) {
                additionalDishService.deleteAdditionalDishesByAdditionalBlock(additionalBlockDTO.getId());
                additionalBlockService.deleteAdditionalBlock(additionalBlockDTO.getId());
            }
            dishService.deleteDish(dishDTO.getId());
        }
        restaurantService.deleteRestaurant(resaurantId);
    }
    @DeleteMapping(value="/category/{id}")
    public void deleteCategoryFromRestaurants(@PathVariable(name="id") Long id){
        restaurantService.deleteCategoryFromRestaurants(id);
    }
}
