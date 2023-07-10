package kz.yeldos.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="t_additional_dishes")
@Data
public class Additional_dish extends BaseModel{

    @Column(name="name")
    private String name;

    @Column(name="price")
    private int price;

    @ManyToOne
    private Additional_block additionalBlock;
}
