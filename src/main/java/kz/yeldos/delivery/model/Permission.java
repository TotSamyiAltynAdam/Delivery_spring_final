package kz.yeldos.delivery.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="t_permissions")
@Data
public class Permission extends BaseModel implements GrantedAuthority {

    @Column(name="role")
    private String role;

    @Override
    public String getAuthority() {
        return this.role;
    }
}
