package bg.softuni.weedinfplanner.model.entity;

import bg.softuni.weedinfplanner.model.entity.enums.CategorySupplierEnum;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class CategorySupplier extends BaseEntity {
    private CategorySupplierEnum name;
    private Set<Offer> offers;

    public CategorySupplier() {
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public CategorySupplierEnum getName() {
        return name;
    }

    public CategorySupplier setName(CategorySupplierEnum name) {
        this.name = name;
        return this;
    }

    @OneToMany(mappedBy = "category")
    public Set<Offer> getOffers() {
        return offers;
    }

    public CategorySupplier setOffers(Set<Offer> offerEntities) {
        this.offers = offerEntities;
        return this;
    }
}
