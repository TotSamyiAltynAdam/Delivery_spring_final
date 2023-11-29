package kz.yeldos.delivery.dto;

import kz.yeldos.delivery.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantDTO {
    private Long id;
    private int ratings;
    private String name;
    private String address;
    private String photo;

    private List<Category> categories;
    private String userEmail;

}
