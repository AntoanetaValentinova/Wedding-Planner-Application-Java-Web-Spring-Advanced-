package bg.softuni.weedinfplanner.service.impl;

import bg.softuni.weedinfplanner.model.entity.Offer;
import bg.softuni.weedinfplanner.model.entity.Picture;
import bg.softuni.weedinfplanner.model.service.PictureAddServiceModel;
import bg.softuni.weedinfplanner.repository.PictureRepository;
import bg.softuni.weedinfplanner.service.CloudinaryImage;
import bg.softuni.weedinfplanner.service.CloudinaryService;
import bg.softuni.weedinfplanner.service.PictureService;
import bg.softuni.weedinfplanner.service.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {
    private final PictureRepository pictureRepository;
    private final CloudinaryService cloudinaryService;

    public PictureServiceImpl(PictureRepository pictureRepository, CloudinaryService cloudinaryService) {
        this.pictureRepository = pictureRepository;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public Picture save(Picture picture) {
        return this.pictureRepository.save(picture);
    }

    @Override
    public void deletePicture(Long picId) {
        Picture picture = this.pictureRepository.findById(picId).orElseThrow(() -> new ObjectNotFoundException());
        this.cloudinaryService.delete(picture.getPublicId());
        this.pictureRepository.deleteById(picId);
    }

    @Override
    public void getPictureEntity(Offer savedOffer, PictureAddServiceModel pictureAddServiceModel) throws IOException {
        CloudinaryImage cloudinaryImage = this.cloudinaryService.upload(pictureAddServiceModel.getPictureFile());
        Picture picture=new Picture();
        picture.setName(pictureAddServiceModel.getNamePicture());
        picture.setPublicId(cloudinaryImage.getPublicId());
        picture.setUrl(cloudinaryImage.getUrl());
        picture.setOffer(savedOffer);
        Picture savedPicture = this.pictureRepository.save(picture);
        savedOffer.getPictures().add(savedPicture);
    }
}
