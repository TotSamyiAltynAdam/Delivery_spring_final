package kz.yeldos.delivery.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

}
