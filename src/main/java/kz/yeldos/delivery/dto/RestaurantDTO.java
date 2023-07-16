package kz.yeldos.delivery.dto;

import kz.yeldos.delivery.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantDTO {
    private Long id;
    private String name;
    private int ratings;
    private String address;

    private List<Category> categories;
    private String userEmail;

}
