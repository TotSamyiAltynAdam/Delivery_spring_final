package kz.yeldos.delivery.mapper;

import kz.yeldos.delivery.dto.DishDTO;
import kz.yeldos.delivery.model.Dish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DishMapper {
    Dish toModel(DishDTO dishDTO);
    DishDTO toDto(Dish dish);
    List<Dish> toModelList(List<DishDTO> dishDTOList);
    List<DishDTO> toDtoList(List<Dish> dishList);
}
