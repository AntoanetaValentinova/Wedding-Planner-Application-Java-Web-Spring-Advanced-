package bg.softuni.weedinfplanner.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {
    private String name;
    private String url;
    private String publicId;
    private Offer offer;

    public Picture() {
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Picture setName(String name) {
        this.name = name;
        return this;
    }

    @Column(nullable = false)
    public String getUrl() {
        return url;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }

    @ManyToOne
    public Offer getOffer() {
        return offer;
    }

    public Picture setOffer(Offer offer) {
        this.offer = offer;
        return this;
    }

    @Column(name="public_id",nullable = false)
    public String getPublicId() {
        return publicId;
    }

    public Picture setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
