package bg.softuni.weedinfplanner.model.service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OfferUpdateServiceModel {
    private String title;
    private String about;
    private String description;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer kmCoverageFromAddress;
    private String phoneNumber;

    public OfferUpdateServiceModel() {
    }

    @NotBlank(message = "Title is required!")
    @Size(min=5,max=100,message = "Title must be between 5 and 100 characters long.")
    public String getTitle() {
        return title;
    }

    public OfferUpdateServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    @NotBlank(message = "About is required!")
    @Size(min=20,max=1000,message = "About must be between 20 and 100  characters long.")
    public String getAbout() {
        return about;
    }

    public OfferUpdateServiceModel setAbout(String about) {
        this.about = about;
        return this;
    }

    @NotBlank(message = "Description is required!")
    @Size(min=20,max=1000,message = "Description must be between 20 and 1000 characters long.")
    public String getDescription() {
        return description;
    }

    public OfferUpdateServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull(message = "Minimal price is required!")
    @Positive(message = "Minimal price must be positive number.")
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public OfferUpdateServiceModel setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    @NotNull(message = "Maximal price is required!")
    @Positive(message = "Maximal price must be positive number.")
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public OfferUpdateServiceModel setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public Integer getKmCoverageFromAddress() {
        return kmCoverageFromAddress;
    }

    public OfferUpdateServiceModel setKmCoverageFromAddress(Integer kmCoverageFromAddress) {
        this.kmCoverageFromAddress = kmCoverageFromAddress;
        return this;
    }

    @NotBlank(message = "Phone number is required!")
    @Size(min=6,max=50,message = "Phone number must be between 6 and 50 characters long.")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OfferUpdateServiceModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
