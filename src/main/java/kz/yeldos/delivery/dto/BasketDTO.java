package kz.yeldos.delivery.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class BasketDTO {

    private String dishName;
    private List<String> additionalDishName;
    private int count;
}
