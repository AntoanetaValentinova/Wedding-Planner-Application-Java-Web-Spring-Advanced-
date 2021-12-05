package bg.softuni.weedinfplanner.model.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {
    private String title;
    private String about;
    private LocalDate created;
    private String description;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;
    private List<Picture> pictures;
    private Supplier supplier;
    private Integer kmCoverageFromAddress;
    private String phoneNumber;
    private List<String> includedAttributes;
    private CategorySupplier category;
    private StatusEnum status;
    private Set<Wedding> weddingsReserved;
    private Set<Wedding> weddingsFavourites;


    public Offer() {
        this.pictures=new ArrayList<>();
        this.includedAttributes=new ArrayList<>();
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public Offer setTitle(String title) {
        this.title = title;
        return this;
    }

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    public String getAbout() {
        return about;
    }

    public Offer setAbout(String about) {
        this.about = about;
        return this;
    }

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    public String getDescription() {
        return description;
    }

    public Offer setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public Offer setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public Offer setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
        return this;
    }

    @Column(nullable = false)
    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public Offer setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    @OneToMany(mappedBy = "offer", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    public List<Picture> getPictures() {
        return pictures;
    }

    public Offer setPictures(List<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }


    @ManyToOne(optional = false)
    public Supplier getSupplier() {
        return supplier;
    }

    public Offer setSupplier(Supplier supplier) {
        this.supplier = supplier;
        return this;
    }

    @Column(name = "km_coverage")
    public Integer getKmCoverageFromAddress() {
        return kmCoverageFromAddress;
    }

    public Offer setKmCoverageFromAddress(Integer kmCoverageFromAddress) {
        this.kmCoverageFromAddress = kmCoverageFromAddress;
        return this;
    }

    @Column(nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Offer setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    @ElementCollection
    public List<String> getIncludedAttributes() {
        return includedAttributes;
    }

    public Offer setIncludedAttributes(List<String> includedAttributes) {
        this.includedAttributes = includedAttributes;
        return this;
    }

    @ManyToOne(optional = false)
    public CategorySupplier getCategory() {
        return category;
    }

    public Offer setCategory(CategorySupplier category) {
        this.category = category;
        return this;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public StatusEnum getStatus() {
        return status;
    }

    public Offer setStatus(StatusEnum status) {
        this.status = status;
        return this;
    }

    @ManyToMany(mappedBy = "reservedOffers",fetch = FetchType.EAGER)
    public Set<Wedding> getWeddingsReserved() {
        return weddingsReserved;
    }

    public Offer setWeddingsReserved(Set<Wedding> weddingsReserved) {
        this.weddingsReserved = weddingsReserved;
        return this;
    }

    @ManyToMany(mappedBy = "favouriteOffers",fetch = FetchType.EAGER)
    public Set<Wedding> getWeddingsFavourites() {
        return weddingsFavourites;
    }

    public Offer setWeddingsFavourites(Set<Wedding> weddingsFavourites) {
        this.weddingsFavourites = weddingsFavourites;
        return this;
    }

    @PrePersist
    public void nowCreated() {
        this.created = LocalDate.now();
    }


}
