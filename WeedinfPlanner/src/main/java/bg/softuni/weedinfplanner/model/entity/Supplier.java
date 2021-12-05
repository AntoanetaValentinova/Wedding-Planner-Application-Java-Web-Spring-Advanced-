package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseUser {
    private String companyName;
    private Address address;
    private Set<Offer> offers;
    private String phoneNumber;

    public Supplier() {
    }

    @Column(name = "company_name", nullable = false)
    public String getCompanyName() {
        return companyName;
    }

    public Supplier setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    @ManyToOne(optional = false)
    public Address getAddress() {
        return address;
    }

    public Supplier setAddress(Address address) {
        this.address = address;
        return this;
    }

    @OneToMany(mappedBy = "supplier")
    public Set<Offer> getOffers() {
        return offers;
    }

    public Supplier setOffers(Set<Offer> offers) {
        this.offers = offers;
        return this;
    }


    @Column(name = "phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Supplier setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
