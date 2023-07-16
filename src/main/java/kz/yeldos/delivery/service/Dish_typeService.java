package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.Dish_typeDTO;
import kz.yeldos.delivery.mapper.Dish_typeMapper;
import kz.yeldos.delivery.repository.Dish_typeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Dish_typeService{
    private final Dish_typeRepository dishTypeRepository;
    private final Dish_typeMapper dishTypeMapper;

    public List<Dish_typeDTO> getDishTypes(){
        return dishTypeMapper.toDtoList(dishTypeRepository.findAll());
    }
    public Dish_typeDTO getDishType(Long id){
        return dishTypeMapper.toDto(dishTypeRepository.findById(id).orElse(null));
    }
    public Dish_typeDTO addDishType(Dish_typeDTO dish_typeDTO){
        return dishTypeMapper.toDto(dishTypeRepository.save(dishTypeMapper.toModel(dish_typeDTO)));
    }
    public Dish_typeDTO updateDishType(Dish_typeDTO dish_typeDTO){
        return dishTypeMapper.toDto(dishTypeRepository.save(dishTypeMapper.toModel(dish_typeDTO)));
    }
    public void deleteDishType(Long id){
        dishTypeRepository.deleteById(id);
    }
}
