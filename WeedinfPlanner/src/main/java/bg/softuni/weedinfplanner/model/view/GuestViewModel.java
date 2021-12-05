package bg.softuni.weedinfplanner.model.view;

import bg.softuni.weedinfplanner.model.entity.enums.AgeEnum;
import bg.softuni.weedinfplanner.model.entity.enums.AttendEnum;
import bg.softuni.weedinfplanner.model.entity.enums.TypeGuestEnum;

public class GuestViewModel {
    private Long id;
    private AttendEnum attend;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private TypeGuestEnum type;
    private AgeEnum age;
    private boolean needHotel;

    public GuestViewModel() {
    }

    public Long getId() {
        return id;
    }

    public GuestViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public AttendEnum getAttend() {
        return attend;
    }

    public GuestViewModel setAttend(AttendEnum attend) {
        this.attend = attend;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public GuestViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public GuestViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public GuestViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public GuestViewModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public TypeGuestEnum getType() {
        return type;
    }

    public GuestViewModel setType(TypeGuestEnum type) {
        this.type = type;
        return this;
    }

    public AgeEnum getAge() {
        return age;
    }

    public GuestViewModel setAge(AgeEnum age) {
        this.age = age;
        return this;
    }

    public boolean isNeedHotel() {
        return needHotel;
    }

    public GuestViewModel setNeedHotel(boolean needHotel) {
        this.needHotel = needHotel;
        return this;
    }
}
