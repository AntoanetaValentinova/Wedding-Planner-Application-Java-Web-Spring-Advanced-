package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "weddings")
public class Wedding extends BaseEntity {
    private LocalDate date;
    private Set<Guest> guests;
    private Budget budget;
    private Set<Offer> favouriteOffers;
    private Set<Offer> reservedOffers;
    private Set<Task> checklist;
    private User user;

    public Wedding() {
        this.reservedOffers=new LinkedHashSet<>();
        this.favouriteOffers=new LinkedHashSet<>();
    }

    @Column
    public LocalDate getDate() {
        return date;
    }

    public Wedding setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    @OneToMany(mappedBy = "weddingToAttend",fetch = FetchType.EAGER)
    public Set<Guest> getGuests() {
        return guests;
    }

    public Wedding setGuests(Set<Guest> guests) {
        this.guests = guests;
        return this;
    }

    @OneToOne
    public Budget getBudget() {
        return budget;
    }

    public Wedding setBudget(Budget budget) {
        this.budget = budget;
        return this;
    }


    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Offer> getFavouriteOffers() {
        return favouriteOffers;
    }

    public Wedding setFavouriteOffers(Set<Offer> favouriteOffers) {
        this.favouriteOffers = favouriteOffers;
        return this;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Offer> getReservedOffers() {
        return reservedOffers;
    }

    public Wedding setReservedOffers(Set<Offer> reservedOffers) {
        this.reservedOffers = reservedOffers;
        return this;
    }


    @OneToMany(mappedBy = "wedding")
    public Set<Task> getChecklist() {
        return checklist;
    }

    public Wedding setChecklist(Set<Task> checklist) {
        this.checklist = checklist;
        return this;
    }

    @OneToOne(mappedBy = "wedding")
    public User getUser() {
        return user;
    }

    public Wedding setUser(User user) {
        this.user = user;
        return this;
    }
}
