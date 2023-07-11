package kz.yeldos.delivery.mapper;

import kz.yeldos.delivery.dto.RestaurantDTO;
import kz.yeldos.delivery.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
    @Mapping(source = "categoryList",target = "categories")
    RestaurantDTO toDto(Restaurant restaurant);
    @Mapping(source = "categories",target = "categoryList")
    Restaurant toModel(RestaurantDTO restaurantDTO);

    List<RestaurantDTO> toDtoList(List<Restaurant> restaurantList);

    List<Restaurant> toModelList(List<RestaurantDTO> restaurantDTOList);
}
