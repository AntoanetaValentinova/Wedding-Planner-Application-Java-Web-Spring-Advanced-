package bg.softuni.weedinfplanner.model.service;

import org.springframework.web.multipart.MultipartFile;

public class PictureAddServiceModel {
    private String namePicture;
    private MultipartFile pictureFile;

    public PictureAddServiceModel() {
    }

    public String getNamePicture() {
        return namePicture;
    }

    public PictureAddServiceModel setNamePicture(String namePicture) {
        this.namePicture = namePicture;
        return this;
    }

    public MultipartFile getPictureFile() {
        return pictureFile;
    }

    public PictureAddServiceModel setPictureFile(MultipartFile pictureFile) {
        this.pictureFile = pictureFile;
        return this;
    }
}
