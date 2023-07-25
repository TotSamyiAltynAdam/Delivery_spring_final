package kz.yeldos.delivery.api;

import kz.yeldos.delivery.dto.Additional_blockDTO;
import kz.yeldos.delivery.dto.DishDTO;
import kz.yeldos.delivery.service.Additional_blockService;
import kz.yeldos.delivery.service.Additional_dishService;
import kz.yeldos.delivery.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/dish")
public class DishRestController {
    private final DishService dishService;
    private final Additional_blockService additionalBlockService;
    private final Additional_dishService additionalDishService;
    @GetMapping
    public List<DishDTO> getDishes(){
        return dishService.getDishes();
    }
    @GetMapping(value="{id}")
    public DishDTO getDish(@PathVariable(name="id") Long id){
        return dishService.getDish(id);
    }
    @PostMapping
    public DishDTO addDish(@RequestBody DishDTO dishDTO){
        return dishService.addDish(dishDTO);
    }
    @PutMapping
    public DishDTO updateDish(@RequestBody DishDTO dishDTO){
        return dishService.updateDish(dishDTO);
    }
    @DeleteMapping(value="{id}")
    public void deleteDish(@PathVariable(name="id") Long dishId){
        List<Additional_blockDTO> additionalBlockDTOList = additionalBlockService.getAdditionalBlocksRelatedToTheParticularDish(dishId);
        for (Additional_blockDTO additionalBlockDTO : additionalBlockDTOList) {
            additionalDishService.deleteAdditionalDishesByAdditionalBlock(additionalBlockDTO.getId());
            additionalBlockService.deleteAdditionalBlock(additionalBlockDTO.getId());
        }
        dishService.deleteDish(dishId);
    }
    @DeleteMapping(value="/dishType/{id}")
    public void deleteDishTypeFromDishes(@PathVariable(name="id") Long dishTypeId){
        dishService.deleteDishTypeFromDishes(dishTypeId);
    }
    @GetMapping(value = "/restaurant/{id}")
    public List<DishDTO> findAllDishesWhereRestaurant(@PathVariable(name="id") Long id){
        return dishService.findDishesWhereRestaurant(id);
    }
    @GetMapping(value="/restaurant/{restaurantId}/dishType/{dishTypeId}")
    public List<DishDTO> findAllDishesWhereRestaurantAndDishType(@PathVariable(name="restaurantId") Long restaurantId,
                                       @PathVariable(name="dishTypeId") Long dishTypeId){
        return dishService.findDishesWhereRestaurantAndDishType(restaurantId,dishTypeId);
    }
}
