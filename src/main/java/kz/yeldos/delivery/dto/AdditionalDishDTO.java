package kz.yeldos.delivery.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AdditionalDishDTO {
    private final List<Long> additionalDish = new ArrayList<>();
}
