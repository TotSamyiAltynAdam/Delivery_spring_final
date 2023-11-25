package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.AdditionalDishDTO;
import kz.yeldos.delivery.dto.BasketDTO;
import kz.yeldos.delivery.model.Additional_dish;
import kz.yeldos.delivery.model.Dish;
import kz.yeldos.delivery.repository.Additional_dishRepository;
import kz.yeldos.delivery.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BasketService {

    private final DishRepository dishRepository;
    private final Additional_dishRepository additionalDishRepository;

    public BasketDTO addDish(Long dishId, AdditionalDishDTO additionalDishDTO) {
        Dish dish = dishRepository.findById(dishId).get();
        if (additionalDishDTO == null) {
            additionalDishDTO = new AdditionalDishDTO();
        }
        List<Additional_dish> allAdditionalDishes = additionalDishRepository.findAllById(additionalDishDTO.getAdditionalDish());
        BasketDTO basketDTO = BasketDTO.builder()
                .dishName(dish.getName())
                .additionalDishName(allAdditionalDishes.stream()
                        .map(Additional_dish::getName)
                        .collect(Collectors.toList()))
                .count(1)
                .build();
        return basketDTO;
    }
}
