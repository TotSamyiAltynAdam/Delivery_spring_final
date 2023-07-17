package kz.yeldos.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="t_conditions")
@Data
public class Condition extends BaseModel{

    @Column(name="type")
    private String type; //must,add,remove
}
