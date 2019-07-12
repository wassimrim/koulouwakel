package com.projetb32.koulouwakel.controller;

import com.projetb32.koulouwakel.entity.Picture;
import com.projetb32.koulouwakel.service.PictureService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Optional<List<Picture>>> retreivePictures() {

        if (pictureService.getAllPicture().filter(g -> g.isEmpty()).isPresent())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(pictureService.getAllPicture(), HttpStatus.OK);

    }

    @GetMapping("/pictures/{pictureId}")
    public ResponseEntity<Optional<Picture>> retreivePictureById(@PathVariable String pictureId) {


        if (!pictureService.getPictureById(Long.parseLong(pictureId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(pictureService.getPictureById(Long.parseLong(pictureId)), HttpStatus.OK);
        }
    }

    @PostMapping("/pictures")
    public ResponseEntity<Picture> addPicture(@RequestBody Picture picture) {
        if (picture != null) {
            if (pictureService.getPictureByLabel(picture.getLabel()).isPresent()) {
                return ResponseEntity.noContent().build();
            }
        }
      //  log.info("affichage"+activite.getEvenement());
        Picture PictureLocal = pictureService.addPicture(picture);

        if (PictureLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(PictureLocal, HttpStatus.OK);
        }
    }

    @PutMapping("/pictures/{pictureId}")
    public ResponseEntity<Picture> updatePicture(@PathVariable String pictureId, @RequestBody Picture picture) {

        if (pictureService.getPictureById(picture.getId()).isPresent()) {

            Picture pictureLocal = pictureService.updatePicture(Long.parseLong(pictureId), picture);

            if (pictureLocal == null) {
                return ResponseEntity.noContent().build();
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

			/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ActiviteId)
					.toUri();*/

            // Status

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
