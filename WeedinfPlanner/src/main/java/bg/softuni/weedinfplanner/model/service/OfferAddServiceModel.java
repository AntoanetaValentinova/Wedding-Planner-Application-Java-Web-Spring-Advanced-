package bg.softuni.weedinfplanner.model.service;

import bg.softuni.weedinfplanner.model.entity.CategorySupplier;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;

import java.math.BigDecimal;
import java.util.List;

public class OfferAddServiceModel {
    private Long id;
    private String title;
    private String about;
    private String description;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private Integer kmCoverageFromAddress;
    private String phoneNumber;
    private List<String> includedAttributes;
    private CategorySupplierEnum category;
    private List<PictureAddServiceModel> picturesBind;

    public OfferAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public OfferAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OfferAddServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAbout() {
        return about;
    }

    public OfferAddServiceModel setAbout(String about) {
        this.about = about;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public OfferAddServiceModel setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public OfferAddServiceModel setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public Integer getKmCoverageFromAddress() {
        return kmCoverageFromAddress;
    }

    public OfferAddServiceModel setKmCoverageFromAddress(Integer kmCoverageFromAddress) {
        this.kmCoverageFromAddress = kmCoverageFromAddress;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OfferAddServiceModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }


    public List<String> getIncludedAttributes() {
        return includedAttributes;
    }

    public OfferAddServiceModel setIncludedAttributes(List<String> includedAttributes) {
        this.includedAttributes = includedAttributes;
        return this;
    }

    public CategorySupplierEnum getCategory() {
        return category;
    }

    public OfferAddServiceModel setCategory(CategorySupplierEnum category) {
        this.category = category;
        return this;
    }

    public List<PictureAddServiceModel> getPicturesBind() {
        return picturesBind;
    }

    public OfferAddServiceModel setPicturesBind(List<PictureAddServiceModel> picturesBind) {
        this.picturesBind = picturesBind;
        return this;
    }
}
