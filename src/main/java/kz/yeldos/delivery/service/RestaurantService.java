package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.RestaurantDTO;
import kz.yeldos.delivery.mapper.RestaurantMapper;
import kz.yeldos.delivery.model.Restaurant;
import kz.yeldos.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public RestaurantDTO addRestaurant(RestaurantDTO restaurant){
        return restaurantMapper.toDto(restaurantRepository.save(restaurantMapper.toModel(restaurant)));
    }
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurant){
        return restaurantMapper.toDto(restaurantRepository.save(restaurantMapper.toModel(restaurant)));
    }
    public void deleteRestaurant(Long id){
        restaurantRepository.deleteById(id);
    }
}
