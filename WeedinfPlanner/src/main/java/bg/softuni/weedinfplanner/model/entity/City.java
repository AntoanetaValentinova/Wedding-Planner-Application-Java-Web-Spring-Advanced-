package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City extends BaseEntity {
    private String name;
    private Region region;

    public City() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    @ManyToOne(optional = false)
    public Region getRegion() {
        return region;
    }

    public City setRegion(Region region) {
        this.region = region;
        return this;
    }
}
