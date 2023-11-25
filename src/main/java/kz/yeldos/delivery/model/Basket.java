package kz.yeldos.delivery.model;

import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Basket implements Serializable {

    @OneToMany
    private List<Dish> dishes;

}

