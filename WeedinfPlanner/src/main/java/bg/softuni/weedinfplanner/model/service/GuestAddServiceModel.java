package bg.softuni.weedinfplanner.model.service;

import bg.softuni.weedinfplanner.model.entity.enums.AgeEnum;
import bg.softuni.weedinfplanner.model.entity.enums.AttendEnum;
import bg.softuni.weedinfplanner.model.entity.enums.TypeGuestEnum;

public class GuestAddServiceModel {
    private Long id;
    private AttendEnum attend;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private TypeGuestEnum type;
    private AgeEnum age;
    private boolean needHotel;

    public GuestAddServiceModel() {
    }

    public AttendEnum getAttend() {
        return attend;
    }

    public Long getId() {
        return id;
    }

    public GuestAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public GuestAddServiceModel setAttend(AttendEnum attend) {
        this.attend = attend;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public GuestAddServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public GuestAddServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public GuestAddServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public GuestAddServiceModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public TypeGuestEnum getType() {
        return type;
    }

    public GuestAddServiceModel setType(TypeGuestEnum type) {
        this.type = type;
        return this;
    }

    public AgeEnum getAge() {
        return age;
    }

    public GuestAddServiceModel setAge(AgeEnum age) {
        this.age = age;
        return this;
    }

    public boolean isNeedHotel() {
        return needHotel;
    }

    public GuestAddServiceModel setNeedHotel(boolean needHotel) {
        this.needHotel = needHotel;
        return this;
    }
}



