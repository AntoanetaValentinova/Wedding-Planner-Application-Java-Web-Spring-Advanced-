package bg.softuni.weedinfplanner.model.view;

import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;

import java.time.LocalDateTime;
import java.util.Set;

public class SuppliersAllViewModel {
    private Long id;
    private String email;
    private LocalDateTime created;
    private String companyName;
    private String phoneNumber;
    private Set<RoleEnum> roleEnums;

    public SuppliersAllViewModel() {
    }

    public Long getId() {
        return id;
    }

    public SuppliersAllViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SuppliersAllViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public SuppliersAllViewModel setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public SuppliersAllViewModel setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SuppliersAllViewModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Set<RoleEnum> getRoleEnums() {
        return roleEnums;
    }

    public SuppliersAllViewModel setRoleEnums(Set<RoleEnum> roleEnums) {
        this.roleEnums = roleEnums;
        return this;
    }
}
