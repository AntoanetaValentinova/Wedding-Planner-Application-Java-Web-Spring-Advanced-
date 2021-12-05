package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseUser {
    private String firstName;
    private String lastName;
    private String partnerFirstName;
    private String partnerLastName;
    private Wedding wedding;

    public User() {
    }


    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPartnerFirstName() {
        return partnerFirstName;
    }

    public User setPartnerFirstName(String partnerFirstName) {
        this.partnerFirstName = partnerFirstName;
        return this;
    }

    public String getPartnerLastName() {
        return partnerLastName;
    }

    public User setPartnerLastName(String partnerLastName) {
        this.partnerLastName = partnerLastName;
        return this;
    }

    @OneToOne(optional = false)
    public Wedding getWedding() {
        return wedding;
    }

    public User setWedding(Wedding wedding) {
        this.wedding = wedding;
        return this;
    }



}
