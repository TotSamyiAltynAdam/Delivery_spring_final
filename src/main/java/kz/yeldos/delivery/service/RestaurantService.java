package kz.yeldos.delivery.service;

import kz.yeldos.delivery.model.Restaurant;
import kz.yeldos.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }
}
