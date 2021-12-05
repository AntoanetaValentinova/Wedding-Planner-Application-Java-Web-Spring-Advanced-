package bg.softuni.weedinfplanner.model.entity;

import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private RoleEnum name;

    public Role() {
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public RoleEnum getName() {
        return name;
    }

    public Role setName(RoleEnum name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return name == role.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
