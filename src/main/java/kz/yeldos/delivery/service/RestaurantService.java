package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.RestaurantDTO;
import kz.yeldos.delivery.mapper.RestaurantMapper;
import kz.yeldos.delivery.model.Category;
import kz.yeldos.delivery.model.Restaurant;
import kz.yeldos.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public List<RestaurantDTO> getRestaurants(){
        return restaurantMapper.toDtoList(restaurantRepository.findAll());
    }
    public RestaurantDTO getRestaurant(Long id){
        return restaurantMapper.toDto(restaurantRepository.findById(id).orElse(null));
    }
    public RestaurantDTO getRestaurantByEmail(String email){
        return restaurantMapper.toDto(restaurantRepository.findByUserEmail(email));
    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurant){
        return restaurantMapper.toDto(restaurantRepository.save(restaurantMapper.toModel(restaurant)));
    }
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurant){
        return restaurantMapper.toDto(restaurantRepository.save(restaurantMapper.toModel(restaurant)));
    }
    public void deleteRestaurant(Long id){
        restaurantRepository.deleteById(id);
    }
    public List<RestaurantDTO> getRestaurantsByCategoryId(Long categoryId){
        Category category = new Category();
        category.setId(categoryId);
        return restaurantRepository.findByCategoryListContaining(category)
                .stream()
                .map(restaurantMapper::toDto)
                .collect(Collectors.toList());
    }
    public void deleteCategoryFromRestaurants(Long categoryId){
        Category category = new Category();
        category.setId(categoryId);
        List<Restaurant> restaurants = restaurantRepository.findByCategoryListContaining(category);
        for(Restaurant restaurant :  restaurants){
            restaurant.getCategoryList().removeIf(c -> c.getId().equals(categoryId));
            restaurantRepository.save(restaurant);
        }

    }
}
