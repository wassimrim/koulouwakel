package com.projetb32.koulouwakel.service;

import com.projetb32.koulouwakel.entity.Picture;
import com.projetb32.koulouwakel.entity.PictureRecipe;
import com.projetb32.koulouwakel.entity.Recipe;
import com.projetb32.koulouwakel.repository.PictureRecipeRepository;
import com.projetb32.koulouwakel.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Component
public class PictureRecipeService {
    @Autowired
    private PictureRecipeRepository pictureRecipeRepository;
    @Autowired
    private  RecipeService recipeService;

    private static String uploadDirectory = System.getProperty("user.dir") + "/src/uploads";



    public PictureRecipe addPictureRecipe(MultipartFile file, Long idRecipe) {
        PictureRecipe p = new PictureRecipe();
        Recipe r ;
        r = recipeService.getRecipeById(idRecipe).get();
        p.setLabel(file.getOriginalFilename());
        p.setRecipe(r);
        Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
        StringBuilder fileName = new StringBuilder();
        fileName.append(file.getOriginalFilename());
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pictureRecipeRepository.save(p);
    }

    public List<PictureRecipe> getAllPictureRecipe() {


        return pictureRecipeRepository.findAll();
    }

    public Optional<PictureRecipe> getPictureRecipeById(Long id) {


        return pictureRecipeRepository.findById(id);

    }

    public Optional<PictureRecipe> getPictureRecipeByLabel(String label) {

        return pictureRecipeRepository.findByLabel(label);
    }

    public void deletePictureRecipe(Long id) {

        PictureRecipe pictureRecipe = pictureRecipeRepository.findById(id).get();
        if (pictureRecipe != null) {
            Path fileNameAndPath = Paths.get(uploadDirectory, pictureRecipe.getLabel());
            try {
                Files.delete(fileNameAndPath);
                pictureRecipeRepository.deleteById(id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public PictureRecipe updatePictureRecipe(long id, String name) {

        PictureRecipe pictureRecipe = pictureRecipeRepository.findById(id).get();
        Path fileNameAndPathSource = Paths.get(uploadDirectory, pictureRecipe.getLabel());
        pictureRecipe.setLabel(name);
        Path currentlyFileNameAndPath = Paths.get(uploadDirectory, name);

        try {
            Files.move(fileNameAndPathSource, currentlyFileNameAndPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        pictureRecipeRepository.save(pictureRecipe);

        return pictureRecipe;
    }

    public PictureRecipe updatePictureRecipe2(Long id, MultipartFile file) {

        PictureRecipe pictureRecipe = pictureRecipeRepository.findById(id).get();
        Path fileNameAndPathSource = Paths.get(uploadDirectory, file.getOriginalFilename());
        pictureRecipe.setLabel(file.getOriginalFilename());
        StringBuilder fileName = new StringBuilder();
        fileName.append(file.getOriginalFilename());
        try {
            Files.write(fileNameAndPathSource, file.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        pictureRecipeRepository.save(pictureRecipe);
        return pictureRecipe;
    }
}
