package bg.softuni.weedinfplanner.model.service;

public class PictureServiceModel {
    private Long id;
    private String name;
    private String url;
    private String publicId;

    public PictureServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public PictureServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PictureServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureServiceModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PictureServiceModel setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
