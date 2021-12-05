package bg.softuni.weedinfplanner.model.view;

public class PictureViewModel {
    private Long id;
    private String name;
    private String url;
    private String publicId;

    public PictureViewModel() {
    }

    public Long getId() {
        return id;
    }

    public PictureViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PictureViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public PictureViewModel setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public PictureViewModel setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
