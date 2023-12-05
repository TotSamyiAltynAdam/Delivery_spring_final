package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.RestaurantDTO;
import kz.yeldos.delivery.mapper.RestaurantMapper;
import kz.yeldos.delivery.model.Category;
import kz.yeldos.delivery.model.Restaurant;
import kz.yeldos.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    private final ImageService imageService;

    public List<RestaurantDTO> getRestaurants(){
        return restaurantMapper.toDtoList(restaurantRepository.findAll());
    }
    public RestaurantDTO getRestaurant(Long id){
        return restaurantMapper.toDto(restaurantRepository.findById(id).orElse(null));
    }
    public RestaurantDTO getRestaurantByEmail(String email){
        return restaurantMapper.toDto(restaurantRepository.findByUserEmail(email));
    }

    public void addRestaurant(RestaurantDTO restaurantDTO, MultipartFile photo){
        restaurantDTO.setPhoto(uploadImage(photo));
        restaurantRepository.save(restaurantMapper.toModel(restaurantDTO));
    }
    @SneakyThrows
    private String uploadImage(MultipartFile multipartFile){
        if(!multipartFile.isEmpty()){
            return imageService.upload(multipartFile.getOriginalFilename(), multipartFile.getInputStream());
        }else{
            return  "";
        }

    }
    public void updateRestaurant(RestaurantDTO restaurantDTO, MultipartFile photo){
        Restaurant restaurant = restaurantMapper.toModel(restaurantDTO);
        restaurant.setPhoto(uploadImage(photo));

        restaurantRepository.save(restaurant);
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
