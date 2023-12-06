package kz.yeldos.delivery.api;

import kz.yeldos.delivery.dto.Additional_blockDTO;
import kz.yeldos.delivery.dto.CategoryDTO;
import kz.yeldos.delivery.dto.DishDTO;
import kz.yeldos.delivery.dto.RestaurantDTO;
import kz.yeldos.delivery.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value="/restaurant")
public class RestaurantRestController {
    private final RestaurantService restaurantService;
    private final DishService dishService;
    private final CategoryService categoryService;
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
    public ResponseEntity<Void> addRestaurant(
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("name") String name,
            @RequestParam("ratings") Integer ratings,
            @RequestParam("address") String address,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("categories") String categories
            ){
        RestaurantDTO restaurant = new RestaurantDTO();
        restaurant.setName(name);
        restaurant.setAddress(address);
        restaurant.setUserEmail(userEmail);
        restaurant.setRatings(ratings);
        String[] categoryIDString = categories.split(",");
        List<Long> categoryIDs = Arrays.stream(categoryIDString)
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<CategoryDTO> categoryIDlist = categoryService.getCategoriesByIds(categoryIDs);
        restaurant.setCategories(categoryIDlist);
        restaurant.setPhoto(null);
        restaurantService.addRestaurant(restaurant, photo);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{restaurant_id}")
    public ResponseEntity<Void> updateRestaurant(
            @PathVariable(name = "restaurant_id") Long id,
            @RequestParam(value = "photo", required = false) MultipartFile photo,
            @RequestParam("name") String name,
            @RequestParam("ratings") Integer ratings,
            @RequestParam("address") String address,
            @RequestParam("userEmail") String userEmail,
            @RequestParam("categories") String categories
    ){
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setId(id);
        restaurantDTO.setName(name);
        restaurantDTO.setAddress(address);
        restaurantDTO.setUserEmail(userEmail);
        restaurantDTO.setRatings(ratings);
        String[] categoryIDString = categories.split(",");
        List<Long> categoryIDs = Arrays.stream(categoryIDString)
                .map(Long::parseLong)
                .collect(Collectors.toList());
        List<CategoryDTO> categoryIDlist = categoryService.getCategoriesByIds(categoryIDs);
        restaurantDTO.setCategories(categoryIDlist);

        restaurantDTO.setPhoto(null);
        restaurantService.updateRestaurant(restaurantDTO, photo);

        return new ResponseEntity<>(HttpStatus.CREATED);
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
