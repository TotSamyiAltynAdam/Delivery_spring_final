package kz.yeldos.delivery.dto;

import kz.yeldos.delivery.model.Permission;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private Boolean preOrder;
    private List<Permission> permissions;
}
