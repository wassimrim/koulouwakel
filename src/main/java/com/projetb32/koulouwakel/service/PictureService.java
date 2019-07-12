package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Picture;

import com.projetb32.koulouwakel.repository.PictureRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PictureService {
    private final PictureRepository  pictureRepository;

    public PictureService(PictureRepository pictureRepository) {
        super();
        this.pictureRepository = pictureRepository;
    }

    public Picture addPicture(Picture picture) {
        return pictureRepository.save(picture);
    }

    public List<Picture> getAllPicture() {


        return pictureRepository.findAll();
    }

    public Optional<Picture> getPictureById(Long id) {

        return pictureRepository.findById(id);

    }

    public Optional<Picture> getPictureByLabel(String label) {

        return pictureRepository.findByLabel(label);
    }

    public void deletePicture(Long id) {

        pictureRepository.deleteById(id);

    }

    public Picture updatePicture(Long id,Picture picture) {


        Picture pictureFound = pictureRepository.findById(id).get();


        pictureFound.setLabel(picture.getLabel());
        pictureRepository.save(pictureFound);

        return pictureFound;
    }
}
