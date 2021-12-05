package bg.softuni.weedinfplanner.service;

import bg.softuni.weedinfplanner.model.entity.Offer;
import bg.softuni.weedinfplanner.model.entity.Picture;
import bg.softuni.weedinfplanner.model.service.PictureAddServiceModel;

import java.io.IOException;

public interface PictureService {
    Picture save(Picture picture);

    void deletePicture(Long picId);

    void getPictureEntity(Offer savedOffer, PictureAddServiceModel pictureAddServiceModel) throws IOException;
}
