package bg.softuni.weedinfplanner.model.service;

import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

public class SuppliersAllServiceModel {
    private Long id;
    private String email;
    private LocalDateTime created;
    private String companyName;
    private String phoneNumber;
    private Set<RoleEnum> roleEnums;

    public SuppliersAllServiceModel() {
        this.roleEnums=new LinkedHashSet<>();
    }

    public Long getId() {
        return id;
    }

    public SuppliersAllServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SuppliersAllServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public SuppliersAllServiceModel setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public SuppliersAllServiceModel setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SuppliersAllServiceModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Set<RoleEnum> getRoleEnums() {
        return roleEnums;
    }

    public SuppliersAllServiceModel setRoleEnums(Set<RoleEnum> roleEnums) {
        this.roleEnums = roleEnums;
        return this;
    }
}
