package kz.yeldos.delivery.service;

import kz.yeldos.delivery.dto.Additional_dishDTO;
import kz.yeldos.delivery.mapper.Additional_dishMapper;
import kz.yeldos.delivery.repository.Additional_dishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Additional_dishService {
    private final Additional_dishMapper additionalDishMapper;
    private final Additional_dishRepository additionalDishRepository;

    public List<Additional_dishDTO> getAdditionalDishes(){
        return additionalDishMapper.toDtoList(additionalDishRepository.findAll());
    }
    public List<Additional_dishDTO> getAdditionalDishesRelatedToTheAdditionalBlockId(Long id){
        return additionalDishMapper.toDtoList(additionalDishRepository.findAllByAdditionalBlockId(id));
    }
    public Additional_dishDTO getAdditionalDish(Long id){
        return additionalDishMapper.toDto(additionalDishRepository.findById(id).orElse(null));
    }
    public Additional_dishDTO addAdditionalDish(Additional_dishDTO additionalDishDTO){
        return additionalDishMapper.toDto(additionalDishRepository.save(additionalDishMapper.toModel(additionalDishDTO)));
    }
    public Additional_dishDTO updateAdditionalDish(Additional_dishDTO additionalDishDTO){
        return additionalDishMapper.toDto(additionalDishRepository.save(additionalDishMapper.toModel(additionalDishDTO)));
    }
    public void deleteAdditionalDish(Long id){
        additionalDishRepository.deleteById(id);
    }
}
