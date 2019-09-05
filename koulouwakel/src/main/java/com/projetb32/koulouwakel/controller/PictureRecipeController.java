package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.Picture;
import com.projetb32.koulouwakel.entity.PictureRecipe;
import com.projetb32.koulouwakel.service.PictureRecipeService;



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



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class PictureRecipeController {
    private static final Logger log = LoggerFactory.getLogger(PictureRecipeController.class);

    private static String uploadDirectory =System.getProperty("user.dir")+"/src/uploads";

    @Autowired
    private PictureRecipeService pictureRecipeService;

    @GetMapping("/pictureRecipes")
    public ResponseEntity<List<PictureRecipe>> retreivePicturesRecipes() {

        if (pictureRecipeService.getAllPictureRecipe().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(pictureRecipeService.getAllPictureRecipe(), HttpStatus.OK);

    }


    @GetMapping("/pictureRecipes/{pictureRecipeId}")
    public ResponseEntity<byte[]> retreivePictureRecipeById(@PathVariable String pictureRecipeId) throws Exception {


        if (!pictureRecipeService.getPictureRecipeById(Long.parseLong(pictureRecipeId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {

            File img = new File("src/uploads/"+pictureRecipeService.getPictureRecipeById(Long.parseLong(pictureRecipeId)).get().getLabel());
            return ResponseEntity.ok().contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(img))).body(Files.readAllBytes(img.toPath()));
        }
    }




    @PostMapping("/pictureRecipes/{idRecipe}")
    public ResponseEntity<PictureRecipe> addPicture( @RequestBody MultipartFile file, @PathVariable String idRecipe) {


        if (file!= null) {
            if (pictureRecipeService.getPictureRecipeByLabel(file.getOriginalFilename()).isPresent()) {
                return ResponseEntity.noContent().build();
            }
        }
        //  log.info("affichage"+activite.getEvenement());
        PictureRecipe PictureLocal = pictureRecipeService.addPictureRecipe(file,Long.parseLong(idRecipe));

        if (PictureLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(PictureLocal, HttpStatus.OK);
        }

    }

    @PutMapping("/pictureRecipes/{pictureRecipeId}/{pictureName}")
    public ResponseEntity<PictureRecipe> updatePicture(@PathVariable String pictureRecipeId, @PathVariable String pictureName) {

        if (!pictureRecipeService.getPictureRecipeByLabel(pictureName).isPresent()) {

            PictureRecipe pictureRecipeLocal = pictureRecipeService.updatePictureRecipe(Long.parseLong(pictureRecipeId), pictureName);

            if (pictureRecipeLocal == null) {
                return ResponseEntity.noContent().build(); //on doit changer le message de retour
            } else {
                return new ResponseEntity<>(pictureRecipeLocal, HttpStatus.OK);
            }
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/picturerecipes/update2/{pictureId}")
    public ResponseEntity<PictureRecipe> updatePictureIfNotExist(@RequestBody MultipartFile file, @PathVariable String pictureId) {

        if (!pictureRecipeService.getPictureRecipeByLabel(file.getOriginalFilename()).isPresent()) {

            PictureRecipe pictureRecipeLocal = pictureRecipeService.updatePictureRecipe2(Long.parseLong(pictureId),file);

            if (pictureRecipeLocal == null) {
                return ResponseEntity.noContent().build(); //on doit changer le message de retour
            } else {
                return new ResponseEntity<>(pictureRecipeLocal, HttpStatus.OK);
            }
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/pictureRecipes/{pictureRecipeId}")
    public ResponseEntity<PictureRecipe> deletePicture(@PathVariable String pictureRecipeId) {

        if (pictureRecipeService.getPictureRecipeById(Long.parseLong(pictureRecipeId)).isPresent()) {

            pictureRecipeService.deletePictureRecipe(Long.parseLong(pictureRecipeId));

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
