package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@MappedSuperclass
public class BaseUser extends BaseEntity {
    private String password;
    private String email;
    private LocalDateTime created;
    private Set<Role> roles;

    public BaseUser() {
    }

    public BaseUser(String password, String email) {
        this.password = password;
        this.email = email;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public BaseUser setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public BaseUser setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(nullable = false)
    public LocalDateTime getCreated() {
        return created;
    }

    public BaseUser setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Role> getRoles() {
        return roles;
    }

    public BaseUser setRoles(Set<Role> roleEntities) {
        this.roles = roleEntities;
        return this;
    }

    @PrePersist
    public void nowCreated() {
        this.created = LocalDateTime.now();
    }


}
