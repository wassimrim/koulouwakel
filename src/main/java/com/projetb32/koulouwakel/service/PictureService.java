package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Picture;

import com.projetb32.koulouwakel.repository.PictureRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PictureService {
    private final PictureRepository  pictureRepository;

    private static String uploadDirectory =System.getProperty("user.dir")+"/src/uploads";

    public PictureService(PictureRepository pictureRepository) {
        super();
        this.pictureRepository = pictureRepository;
    }

    public Picture addPicture(MultipartFile file)
    {
        Picture p = new Picture();
        p.setLabel(file.getOriginalFilename());
        Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
        StringBuilder fileName = new StringBuilder();
        fileName.append(file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }

        return pictureRepository.save(p);
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

        Picture picture = pictureRepository.findById(id).get();
        if(picture != null)
        {
            Path fileNameAndPath = Paths.get(uploadDirectory,picture.getLabel());
            try {
                Files.delete(fileNameAndPath);
                pictureRepository.deleteById(id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        }

    public Picture updatePicture(Long id,String name) {

        Picture picture = pictureRepository.findById(id).get();
        Path fileNameAndPathSource = Paths.get(uploadDirectory,picture.getLabel());
        picture.setLabel(name);
        Path  currentlyFileNameAndPath = Paths.get(uploadDirectory,name);

        try {
            Files.move(fileNameAndPathSource,currentlyFileNameAndPath,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pictureRepository.save(picture);

        return picture;
    }
    public Picture updatePicture2(Long id,MultipartFile file) {

        Picture picture = pictureRepository.findById(id).get();
        Path fileNameAndPathSource = Paths.get(uploadDirectory,file.getOriginalFilename());
        picture.setLabel(file.getOriginalFilename());
       // Path  currentlyFileNameAndPath = Paths.get(uploadDirectory,name);
        StringBuilder fileName = new StringBuilder();
        fileName.append(file.getOriginalFilename());
        try {
            Files.write(fileNameAndPathSource, file.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

        pictureRepository.save(picture);

        return picture;
    }
}
