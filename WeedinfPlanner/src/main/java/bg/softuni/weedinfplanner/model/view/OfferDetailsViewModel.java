package bg.softuni.weedinfplanner.model.view;

import bg.softuni.weedinfplanner.model.entity.Picture;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class OfferDetailsViewModel {
    private Long id;
    private String title;
    private String about;
    private String description;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private List<PictureViewModel> pictures;
    private String supplier;
    private Integer kmCoverageFromAddress;
    private String phoneNumber;
    private List<String> includedAttributes;
    private String address;
    private String city;
    private String region;

    public Long getId() {
        return id;
    }

    public OfferDetailsViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OfferDetailsViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAbout() {
        return about;
    }

    public OfferDetailsViewModel setAbout(String about) {
        this.about = about;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OfferDetailsViewModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public OfferDetailsViewModel setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public OfferDetailsViewModel setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public List<PictureViewModel> getPictures() {
        return pictures;
    }

    public OfferDetailsViewModel setPictures(List<PictureViewModel> pictures) {
        this.pictures = pictures;
        return this;
    }


    public String getSupplier() {
        return supplier;
    }

    public OfferDetailsViewModel setSupplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public Integer getKmCoverageFromAddress() {
        return kmCoverageFromAddress;
    }

    public OfferDetailsViewModel setKmCoverageFromAddress(Integer kmCoverageFromAddress) {
        this.kmCoverageFromAddress = kmCoverageFromAddress;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public OfferDetailsViewModel setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public List<String> getIncludedAttributes() {
        return includedAttributes;
    }

    public OfferDetailsViewModel setIncludedAttributes(List<String> includedAttributes) {
        this.includedAttributes = includedAttributes;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public OfferDetailsViewModel setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public OfferDetailsViewModel setCity(String city) {
        this.city = city;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public OfferDetailsViewModel setRegion(String region) {
        this.region = region;
        return this;
    }
}
