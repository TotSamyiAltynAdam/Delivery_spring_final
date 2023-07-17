package kz.yeldos.delivery.dto;

import kz.yeldos.delivery.model.Additional_block;
import lombok.Data;

@Data
public class Additional_dishDTO {
    private Long id;
    private String name;
    private int price;
    private Additional_block additionalBlock;

}
