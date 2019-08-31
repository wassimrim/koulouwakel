package com.projetb32.koulouwakel.controller;

import com.projetb32.koulouwakel.entity.Picture;
import com.projetb32.koulouwakel.service.PictureService;


import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import sun.nio.ch.IOUtil;

import javax.activation.FileTypeMap;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class PictureController {
    private static final Logger log = LoggerFactory.getLogger(PictureController.class);

     private static String uploadDirectory =System.getProperty("user.dir")+"/src/uploads";

    @Autowired
    private PictureService pictureService;

    @GetMapping("/pictures")
    public ResponseEntity<List<Picture>> retreivePictures() {

        if (pictureService.getAllPicture().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(pictureService.getAllPicture(), HttpStatus.OK);

    }


     @GetMapping("/pictures/{pictureId}")
    public ResponseEntity<byte[]> retreivePictureById(@PathVariable String pictureId) throws Exception {


        if (!pictureService.getPictureById(Long.parseLong(pictureId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {

            File img = new File("src/uploads/"+pictureService.getPictureById(Long.parseLong(pictureId)).get().getLabel());
            return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
        }
    }




    @PostMapping("/pictures")
    public ResponseEntity<Picture> addPicture( @RequestBody MultipartFile file) {


         if (file!= null) {
            if (pictureService.getPictureByLabel(file.getOriginalFilename()).isPresent()) {
                return ResponseEntity.noContent().build();
            }
        }
      //  log.info("affichage"+activite.getEvenement());
        Picture PictureLocal = pictureService.addPicture(file);

        if (PictureLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(PictureLocal, HttpStatus.OK);
        }

    }





    @PutMapping("/pictures/{pictureId}/{pictureName}")
    public ResponseEntity<Picture> updatePicture(@PathVariable String pictureId, @PathVariable String pictureName) {

        if (!pictureService.getPictureByLabel(pictureName).isPresent()) {

            Picture pictureLocal = pictureService.updatePicture(Long.parseLong(pictureId), pictureName);

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
    public ResponseEntity<Picture> updatePictureIfNotExist(@RequestBody MultipartFile file,@PathVariable String pictureId) {

        if (!pictureService.getPictureByLabel(file.getOriginalFilename()).isPresent()) {

            Picture pictureLocal = pictureService.updatePicture2(Long.parseLong(pictureId),file);

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
    public ResponseEntity<Picture> deletePicture(@PathVariable String pictureId) {

        if (pictureService.getPictureById(Long.parseLong(pictureId)).isPresent()) {

            pictureService.deletePicture(Long.parseLong(pictureId));

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
