package kz.yeldos.delivery.dto;

import kz.yeldos.delivery.model.Condition;
import kz.yeldos.delivery.model.Dish;
import lombok.Data;

@Data
public class Additional_blockDTO {
    private Long id;
    private String name;
    private String description;
    private Condition conditionType;
    private Dish dish;

}
