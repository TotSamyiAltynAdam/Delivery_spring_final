package kz.yeldos.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "t_restaurants")
@Data
public class Restaurant extends BaseModel{

    @Column(name="name")
    private String name;

    @Column(name="ratings")
    private int ratings;

    @Column(name="address")
    private String address;

    @ManyToMany
    private List<Category> categoryList;

    @Column(name="user_email")
    private String userEmail;
}
