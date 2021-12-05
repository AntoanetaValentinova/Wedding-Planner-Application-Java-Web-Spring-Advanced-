package bg.softuni.weedinfplanner.model.entity;

import bg.softuni.weedinfplanner.model.entity.enums.AgeEnum;
import bg.softuni.weedinfplanner.model.entity.enums.AttendEnum;
import bg.softuni.weedinfplanner.model.entity.enums.TypeGuestEnum;

import javax.persistence.*;

@Entity
@Table(name = "guests")
public class Guest extends BaseEntity {
    private AttendEnum attend;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private TypeGuestEnum type;
    private Wedding weddingToAttend;
    private AgeEnum age;
    private boolean needHotel;


    public Guest() {
    }


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public AttendEnum getAttend() {
        return attend;
    }

    public Guest setAttend(AttendEnum attend) {
        this.attend = attend;
        return this;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public Guest setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public Guest setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public Guest setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Guest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public TypeGuestEnum getType() {
        return type;
    }

    public Guest setType(TypeGuestEnum type) {
        this.type = type;
        return this;
    }

    @ManyToOne
    public Wedding getWeddingToAttend() {
        return weddingToAttend;
    }

    public Guest setWeddingToAttend(Wedding weddingToAttend) {
        this.weddingToAttend = weddingToAttend;
        return this;
    }

    @Enumerated(EnumType.STRING)
    public AgeEnum getAge() {
        return age;
    }

    public Guest setAge(AgeEnum age) {
        this.age = age;
        return this;
    }

    @Column(name="need_hotel")
    public boolean isNeedHotel() {
        return needHotel;
    }

    public Guest setNeedHotel(boolean needHotel) {
        this.needHotel = needHotel;
        return this;
    }

}
