package bg.softuni.weedinfplanner.model.binding;

import bg.softuni.weedinfplanner.model.binding.validation.MultipartFileNotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PictureAddBindingModel {
    private String namePicture;
    private MultipartFile pictureFile;

    public PictureAddBindingModel() {
    }

    @NotBlank(message = "Picture name is required!")
    @Size(min=1,max=20,message = "Picture name must be between 1 and 20 characters!")
    public String getNamePicture() {
        return namePicture;
    }

    public PictureAddBindingModel setNamePicture(String namePicture) {
        this.namePicture = namePicture;
        return this;
    }

    @MultipartFileNotEmpty(message = "Picture file is required!")
    public MultipartFile getPictureFile() {
        return pictureFile;
    }

    public PictureAddBindingModel setPictureFile(MultipartFile pictureFile) {
        this.pictureFile = pictureFile;
        return this;
    }
}
