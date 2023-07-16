package kz.yeldos.delivery.dto;

import kz.yeldos.delivery.model.Dish_type;
import kz.yeldos.delivery.model.Restaurant;
import lombok.Data;

@Data
public class DishDTO {
    private Long id;
    private String name;
    private String description;
    private int price;
    private String photo;
    private Dish_type dishType;
    private Restaurant restaurant;
}
