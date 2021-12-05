package bg.softuni.weedinfplanner.model.view;

import bg.softuni.weedinfplanner.model.entity.StatusEnum;
import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OffersAllViewModel {
    private Long id;
    private String title;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private CategorySupplierEnum category;
    private StatusEnum status;
    private LocalDate created;
    private List<PictureViewModel> pictures;

    public Long getId() {
        return id;
    }

    public OffersAllViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public OffersAllViewModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public OffersAllViewModel setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public OffersAllViewModel setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public CategorySupplierEnum getCategory() {
        return category;
    }

    public OffersAllViewModel setCategory(CategorySupplierEnum category) {
        this.category = category;
        return this;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public OffersAllViewModel setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    public List<PictureViewModel> getPictures() {
        return pictures;
    }

    public OffersAllViewModel setPictures(List<PictureViewModel> pictures) {
        this.pictures = pictures;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public OffersAllViewModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }
}
