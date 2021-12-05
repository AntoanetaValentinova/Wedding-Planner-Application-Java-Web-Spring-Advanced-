package bg.softuni.weedinfplanner.model.service;

import bg.softuni.weedinfplanner.model.entity.StatusEnum;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;

import java.math.BigDecimal;
import java.util.List;

public class OffersAllServiceModel {
    private Long id;
    private String title;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private CategorySupplierEnum category;
    private StatusEnum status;
    private List<PictureServiceModel> pictures;


    public Long getId() {
        return id;
    }

    public OffersAllServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OffersAllServiceModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public OffersAllServiceModel setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public OffersAllServiceModel setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public CategorySupplierEnum getCategory() {
        return category;
    }

    public OffersAllServiceModel setCategory(CategorySupplierEnum category) {
        this.category = category;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public OffersAllServiceModel setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public List<PictureServiceModel> getPictures() {
        return pictures;
    }

    public OffersAllServiceModel setPictures(List<PictureServiceModel> pictures) {
        this.pictures = pictures;
        return this;
    }
}
