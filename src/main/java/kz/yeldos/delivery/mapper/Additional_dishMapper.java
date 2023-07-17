package kz.yeldos.delivery.mapper;

import kz.yeldos.delivery.dto.Additional_dishDTO;
import kz.yeldos.delivery.model.Additional_dish;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Additional_dishMapper {
    Additional_dishDTO toDto(Additional_dish additionalDish);
    Additional_dish toModel(Additional_dishDTO additionalDishDTO);
    List<Additional_dishDTO> toDtoList(List<Additional_dish> additional_dishList);
    List<Additional_dish> toModelList(List<Additional_dishDTO> additional_dishDTOList);
}
