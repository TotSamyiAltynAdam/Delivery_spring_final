package kz.yeldos.delivery.api;

import kz.yeldos.delivery.dto.Dish_typeDTO;
import kz.yeldos.delivery.service.Dish_typeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/dishType")
public class DishTypeRestController {
    private final Dish_typeService dishTypeService;

    @GetMapping
    public List<Dish_typeDTO> getDishTypes(){
        return dishTypeService.getDishTypes();
    }
    @GetMapping(value="{id}")
    public Dish_typeDTO getDishType(@PathVariable(name="id") Long id){
        return dishTypeService.getDishType(id);
    }
    @PostMapping
    public Dish_typeDTO addDishType(@RequestBody Dish_typeDTO dish_typeDTO){
        return dishTypeService.addDishType(dish_typeDTO);
    }
    @PutMapping
    public Dish_typeDTO updateDishType(@RequestBody Dish_typeDTO dish_typeDTO){
        return dishTypeService.updateDishType(dish_typeDTO);
    }
    @DeleteMapping(value="{id}")
    public void deleteDishType(@PathVariable(name="id") Long id){
        dishTypeService.deleteDishType(id);
    }
}
