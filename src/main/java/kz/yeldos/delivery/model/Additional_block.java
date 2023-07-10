package kz.yeldos.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="t_additional_blocks")
@Data
public class Additional_block extends BaseModel{

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToOne
    private Condition conditionType;

    @ManyToOne
    private Dish dish;
}
