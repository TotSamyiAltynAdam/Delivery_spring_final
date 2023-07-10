package kz.yeldos.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="t_categories")
@Data
public class Category extends BaseModel{

    @Column(name="name")
    private String name;
}
