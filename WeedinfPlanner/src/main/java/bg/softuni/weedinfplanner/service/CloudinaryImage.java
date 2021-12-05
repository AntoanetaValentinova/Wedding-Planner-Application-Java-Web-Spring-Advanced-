package bg.softuni.weedinfplanner.service;

public class CloudinaryImage {
    private String url;
    private String publicId;

    public CloudinaryImage() {
    }

    public String getUrl() {
        return url;
    }

    public CloudinaryImage setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getPublicId() {
        return publicId;
    }

    public CloudinaryImage setPublicId(String publicId) {
        this.publicId = publicId;
        return this;
    }
}
