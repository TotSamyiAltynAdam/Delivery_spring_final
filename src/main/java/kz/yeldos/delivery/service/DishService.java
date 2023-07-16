package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.DishDTO;
import kz.yeldos.delivery.mapper.DishMapper;
import kz.yeldos.delivery.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    public List<DishDTO> getDishes(){
        return dishMapper.toDtoList(dishRepository.findAll());
    }
    public DishDTO getDish(Long id){
        return dishMapper.toDto(dishRepository.findById(id).orElse(null));
    }
    public DishDTO addDish(DishDTO dishDTO){
        return dishMapper.toDto(dishRepository.save(dishMapper.toModel(dishDTO)));
    }
    public DishDTO updateDish(DishDTO dishDTO){
        return dishMapper.toDto(dishRepository.save(dishMapper.toModel(dishDTO)));
    }
    public void deleteDish(Long id){
        dishRepository.deleteById(id);
    }
    public List<DishDTO> findDishesWhereRestaurant(Long id){
        return dishMapper.toDtoList(dishRepository.findAllByRestaurantId(id));
    }
}
