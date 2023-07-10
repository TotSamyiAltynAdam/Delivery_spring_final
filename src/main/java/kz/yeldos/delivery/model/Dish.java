package kz.yeldos.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="t_dishes")
@Data
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private int price;

    @Column(name="photo")
    private String photo;

    @ManyToOne
    private Dish_type dishType;

    @ManyToOne
    private Restaurant restaurant;
}
