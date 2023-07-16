package kz.yeldos.delivery.mapper;

import kz.yeldos.delivery.dto.Dish_typeDTO;
import kz.yeldos.delivery.model.Dish_type;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface Dish_typeMapper {
    Dish_type toModel(Dish_typeDTO dish_typeDTO);
    Dish_typeDTO toDto(Dish_type dish_type);
    List<Dish_typeDTO> toDtoList(List<Dish_type> dish_typeList);
    List<Dish_type> toModelList(List<Dish_typeDTO> dish_typeDTOList);
}
