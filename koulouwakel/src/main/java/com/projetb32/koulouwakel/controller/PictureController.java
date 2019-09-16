package com.projetb32.koulouwakel.controller;

import com.projetb32.koulouwakel.entity.Picture;
import com.projetb32.koulouwakel.service.PictureService;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.activation.FileTypeMap;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class PictureController {
    private static final Logger log = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    private PictureService pictureService;

    @GetMapping("/pictures")
    public ResponseEntity<List<Picture>> retreivePictures() {

        List<Picture> pictureList = null;
        pictureList = pictureService.getAllPicture();
        if (pictureList.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(pictureList, HttpStatus.OK);
    }


    @GetMapping("/pictures/{pictureId}")
    public ResponseEntity<byte[]> retreivePictureById(@PathVariable String pictureId) throws Exception {

        Optional<Picture> picture = null;
        picture = pictureService.getPictureById(Long.parseLong(pictureId));

        if (!picture.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            File img = new File("src/uploads/" + picture.get().getLabel());
            return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
        }
    }


    @PostMapping("/pictures")
    public ResponseEntity<Picture> addPicture(@RequestBody MultipartFile file) {


        if (file != null) {
            if (pictureService.getPictureByLabel(file.getOriginalFilename()).isPresent()) {
                return ResponseEntity.noContent().build();
            }
        }

        Picture PictureLocal = pictureService.addPicture(file);

        if (PictureLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(PictureLocal, HttpStatus.OK);

    }


    @PutMapping("/pictures/{pictureId}/{pictureName}")
    public ResponseEntity<Picture> updatePicture(@PathVariable long pictureId, @PathVariable String pictureName) {

        if (!pictureService.getPictureByLabel(pictureName).isPresent()) {

            Picture pictureLocal = pictureService.updatePicture(pictureId, pictureName);

            if (pictureLocal == null) {
                return ResponseEntity.noContent().build(); //on doit changer le message de retour
            } else {
                return new ResponseEntity<>(pictureLocal, HttpStatus.OK);
            }
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/pictures/update2/{pictureId}")
    public ResponseEntity<Picture> updatePictureIfNotExist(@RequestBody MultipartFile file, @PathVariable String pictureId) {

        if (!pictureService.getPictureByLabel(file.getOriginalFilename()).isPresent()) {

            Picture pictureLocal = pictureService.updatePicture2(Long.parseLong(pictureId), file);

            if (pictureLocal == null) {
                return ResponseEntity.noContent().build(); //on doit changer le message de retour
            } else {
                return new ResponseEntity<>(pictureLocal, HttpStatus.OK);
            }
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/pictures/{pictureId}")
    public ResponseEntity<Picture> deletePicture(@PathVariable long pictureId) {
        pictureService.deletePicture(pictureId);
        return ResponseEntity.accepted().build();

    }
}
