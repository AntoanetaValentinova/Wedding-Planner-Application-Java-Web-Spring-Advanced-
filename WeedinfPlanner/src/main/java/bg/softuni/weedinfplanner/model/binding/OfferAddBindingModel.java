package bg.softuni.weedinfplanner.model.binding;

import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class OfferAddBindingModel {
    private String title;
    private String about;
    private String description;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer kmCoverageFromAddress;
    private String phoneNumber;
    private List<String> includedAttributes;
    private CategorySupplierEnum category;
    private List<PictureAddBindingModel> picturesBind;

    public OfferAddBindingModel() {
    }

    @NotBlank(message = "Title is required!")
    @Size(min=5,max=100,message = "Title must be between 5 and 100 characters long.")
    public String getTitle() {
        return title;
    }

    public OfferAddBindingModel setTitle(String title) {
        this.title = title;
        return this;
    }

    @NotBlank(message = "About is required!")
    @Size(min=20,max=1000,message = "About must be between 20 and 100  characters long.")
    public String getAbout() {
        return about;
    }

    public OfferAddBindingModel setAbout(String about) {
        this.about = about;
        return this;
    }

    @NotBlank(message = "Description is required!")
    @Size(min=20,max=1000,message = "Description must be between 20 and 1000 characters long.")
    public String getDescription() {
        return description;
    }

    public OfferAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull(message = "Minimal price is required!")
    @Positive(message = "Minimal price must be positive number.")
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public OfferAddBindingModel setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    @NotNull(message = "Maximal price is required!")
    @Positive(message = "Maximal price must be positive number.")
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public OfferAddBindingModel setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }


    public Integer getKmCoverageFromAddress() {
        return kmCoverageFromAddress;
    }

    public OfferAddBindingModel setKmCoverageFromAddress(Integer kmCoverageFromAddress) {
        this.kmCoverageFromAddress = kmCoverageFromAddress;
        return this;
    }

    @NotBlank(message = "Phone number is required!")
    @Size(min=6,max=50,message = "Phone number must be between 6 and 50 characters long.")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OfferAddBindingModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public List<@NotBlank String> getIncludedAttributes() {
        return includedAttributes;
    }

    public OfferAddBindingModel setIncludedAttributes(List<String> includedAttributes) {
        this.includedAttributes = includedAttributes;
        return this;
    }

    @NotNull(message = "Please, select category!")
    public CategorySupplierEnum getCategory() {
        return category;
    }

    public OfferAddBindingModel setCategory(CategorySupplierEnum category) {
        this.category = category;
        return this;
    }

    @Valid
    public List<PictureAddBindingModel> getPicturesBind() {
        return picturesBind;
    }

    public OfferAddBindingModel setPicturesBind(List<PictureAddBindingModel> picturesBind) {
        this.picturesBind = picturesBind;
        return this;
    }
}
