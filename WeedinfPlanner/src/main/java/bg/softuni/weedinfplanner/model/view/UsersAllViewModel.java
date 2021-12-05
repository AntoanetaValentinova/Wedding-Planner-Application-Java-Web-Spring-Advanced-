package bg.softuni.weedinfplanner.model.view;

import bg.softuni.weedinfplanner.model.entity.enums.RoleEnum;

import java.time.LocalDateTime;
import java.util.Set;

public class UsersAllViewModel {
    private Long id;
    private String email;
    private LocalDateTime created;
    private String firstName;
    private String lastName;
    private String profilePictureUrl;
    private Set<RoleEnum> roleEnums;

    public UsersAllViewModel() {
    }

    public Long getId() {
        return id;
    }

    public UsersAllViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UsersAllViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public UsersAllViewModel setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UsersAllViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UsersAllViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public UsersAllViewModel setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
        return this;
    }

    public Set<RoleEnum> getRoleEnums() {
        return roleEnums;
    }

    public UsersAllViewModel setRoleEnums(Set<RoleEnum> roleEnums) {
        this.roleEnums = roleEnums;
        return this;
    }
}
