package bg.softuni.weedinfplanner.model.service;

import bg.softuni.weedinfplanner.model.entity.Role;
import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

public class UsersAllServiceModel {
    private Long id;
    private String email;
    private LocalDateTime created;
    private String firstName;
    private String lastName;
    private String profilePictureUrl;
    private Set<RoleEnum> roleEnums;

    public UsersAllServiceModel() {
        this.roleEnums=new LinkedHashSet<>();
    }

    public Long getId() {
        return id;
    }

    public UsersAllServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UsersAllServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public UsersAllServiceModel setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UsersAllServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UsersAllServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public UsersAllServiceModel setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
        return this;
    }

    public Set<RoleEnum> getRoleEnums() {
        return roleEnums;
    }

    public UsersAllServiceModel setRoleEnums(Set<RoleEnum> roleEnums) {
        this.roleEnums = roleEnums;
        return this;
    }
}
