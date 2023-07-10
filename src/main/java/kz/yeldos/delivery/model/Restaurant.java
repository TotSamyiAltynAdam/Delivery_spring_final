package kz.yeldos.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "t_restaurants")
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="ratings")
    private int ratings;

    @Column(name="address")
    private String address;

    @ManyToMany
    private List<Category> categoryList;
}
