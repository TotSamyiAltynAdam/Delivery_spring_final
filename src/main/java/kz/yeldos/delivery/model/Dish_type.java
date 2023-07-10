package kz.yeldos.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="t_dish_types")
@Data
public class Dish_type extends BaseModel{

    @Column(name="name")
    private String name;
}
