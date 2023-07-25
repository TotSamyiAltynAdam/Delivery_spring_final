package kz.yeldos.delivery.api;

import kz.yeldos.delivery.dto.Additional_dishDTO;
import kz.yeldos.delivery.service.Additional_dishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/additionalDish")
public class AdditionalDishRestController {
    private final Additional_dishService additionalDishService;
    @GetMapping
    public List<Additional_dishDTO> additionalDishList(){
        return additionalDishService.getAdditionalDishes();
    }
    @GetMapping(value="/additionalBlock/{id}")
    public List<Additional_dishDTO> getAdditionalDishesRelatedToTheAdditionalBlockId(@PathVariable(name="id")Long id){
        return additionalDishService.getAdditionalDishesRelatedToTheAdditionalBlockId(id);
    }

    @GetMapping(value="{id}")
    public Additional_dishDTO getAdditionalDish(@PathVariable(name="id") Long id){
        return additionalDishService.getAdditionalDish(id);
    }
    @PostMapping
    public Additional_dishDTO addAdditionalDish(@RequestBody Additional_dishDTO additionalDishDTO){
        return additionalDishService.addAdditionalDish(additionalDishDTO);
    }
    @PutMapping
    public Additional_dishDTO updateAdditionalDish(@RequestBody Additional_dishDTO additionalDishDTO){
        return additionalDishService.updateAdditionalDish(additionalDishDTO);
    }
    @DeleteMapping(value="{id}")
    public void deleteAdditionalDish(@PathVariable (name="id") Long id){
        additionalDishService.deleteAdditionalDish(id);
    }
}
