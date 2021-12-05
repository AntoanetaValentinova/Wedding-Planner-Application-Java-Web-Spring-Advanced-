package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "regions")
public class Region extends BaseEntity {
    private String name;
    private Set<City> cities;

    public String getName() {
        return name;
    }

    public Region setName(String name) {
        this.name = name;
        return this;
    }

    @OneToMany(mappedBy = "region")
    public Set<City> getCities() {
        return cities;
    }

    public Region setCities(Set<City> cities) {
        this.cities = cities;
        return this;
    }
}
