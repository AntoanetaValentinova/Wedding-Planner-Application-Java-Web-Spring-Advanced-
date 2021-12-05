package bg.softuni.weedinfplanner.model.service;

import bg.softuni.weedinfplanner.model.entity.enums.AgeEnum;
import bg.softuni.weedinfplanner.model.entity.enums.AttendEnum;
import bg.softuni.weedinfplanner.model.entity.enums.TypeGuestEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GuestUpdateServiceModel {
    private Long id;
    private AttendEnum attend;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private TypeGuestEnum type;
    private AgeEnum age;
    private boolean needHotel;

    public GuestUpdateServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public GuestUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }


    public AttendEnum getAttend() {
        return attend;
    }

    public GuestUpdateServiceModel setAttend(AttendEnum attend) {
        this.attend = attend;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public GuestUpdateServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public GuestUpdateServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public GuestUpdateServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public GuestUpdateServiceModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public TypeGuestEnum getType() {
        return type;
    }

    public GuestUpdateServiceModel setType(TypeGuestEnum type) {
        this.type = type;
        return this;
    }

    public AgeEnum getAge() {
        return age;
    }

    public GuestUpdateServiceModel setAge(AgeEnum age) {
        this.age = age;
        return this;
    }

    public boolean isNeedHotel() {
        return needHotel;
    }

    public GuestUpdateServiceModel setNeedHotel(boolean needHotel) {
        this.needHotel = needHotel;
        return this;
    }
}



