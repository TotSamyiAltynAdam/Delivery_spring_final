package kz.yeldos.delivery.dto;

import lombok.Data;

import java.util.List;

@Data
public class RestaurantDTO {
    private Long id;
    private Integer ratings;
    private String name;
    private String address;
    private String photo;

    private List<CategoryDTO> categories;
    private String userEmail;

}
