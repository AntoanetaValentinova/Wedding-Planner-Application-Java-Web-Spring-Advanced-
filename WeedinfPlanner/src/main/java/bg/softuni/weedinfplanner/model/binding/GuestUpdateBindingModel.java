package bg.softuni.weedinfplanner.model.binding;

import bg.softuni.weedinfplanner.model.entity.enums.AgeEnum;
import bg.softuni.weedinfplanner.model.entity.enums.AttendEnum;
import bg.softuni.weedinfplanner.model.entity.enums.TypeGuestEnum;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GuestUpdateBindingModel {
    private Long id;
    private AttendEnum attend;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private AgeEnum age;
    private boolean needHotel;

    public GuestUpdateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public GuestUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    @NotNull(message = "Please, enter attend status!")
    public AttendEnum getAttend() {
        return attend;
    }

    public GuestUpdateBindingModel setAttend(AttendEnum attend) {
        this.attend = attend;
        return this;
    }

    @NotBlank(message = "Please, enter guest first name!")
    @Size(min = 2, max = 25, message = "First name must be between 2 and 25 characters!")
    public String getFirstName() {
        return firstName;
    }

    public GuestUpdateBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @NotBlank(message = "Please, enter guest last name!")
    @Size(min = 2, max = 25, message = "Last name must be between 2 and 25 characters!")
    public String getLastName() {
        return lastName;
    }

    public GuestUpdateBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public GuestUpdateBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public GuestUpdateBindingModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public AgeEnum getAge() {
        return age;
    }

    public GuestUpdateBindingModel setAge(AgeEnum age) {
        this.age = age;
        return this;
    }

    public boolean isNeedHotel() {
        return needHotel;
    }

    public GuestUpdateBindingModel setNeedHotel(boolean needHotel) {
        this.needHotel = needHotel;
        return this;
    }
}



