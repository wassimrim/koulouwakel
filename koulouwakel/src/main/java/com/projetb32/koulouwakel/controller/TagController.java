package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.Recipe;
import com.projetb32.koulouwakel.entity.Tag;
import com.projetb32.koulouwakel.service.TagService;
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
public class TagController {

    @Autowired
    private TagService tagService;


    @GetMapping("/tags")
    public ResponseEntity<List<Tag>> retreiveTag() {

        List<Tag> tagList = null;
        tagList = tagService.getAllTag();

        if (tagList.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(tagList, HttpStatus.OK);

    }

    @GetMapping("/tags/tagid/{tagId}")
    public ResponseEntity<Optional<Tag>> retreiveTagById(@PathVariable long tagId) {

        Optional<Tag> tagList = null;
        tagList = tagService.getTagById(tagId);
        if (!tagList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(tagList, HttpStatus.OK);
    }

    @GetMapping("/tags/taglabel/{tagLabel}")
    public ResponseEntity<Optional<Tag>> retreiveTagByLabel(@PathVariable String tagLabel) {

        Optional<Tag> tagList = null;
        tagList = tagService.getTagByLabel(tagLabel);
        if (!tagList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(tagList, HttpStatus.OK);
    }

    @GetMapping("/tags/recipes/{tagId}")
    public ResponseEntity<List<Recipe>> findRecipesByTagId(@PathVariable long tagId) {
        List<Recipe> listRecipe = null;
        listRecipe = tagService.findRecipesByTagId(tagId);
        if (listRecipe == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(listRecipe, HttpStatus.OK);
    }


    @PostMapping("/tags")
    public ResponseEntity<Tag> addTag(@RequestBody Tag tag) {
        Tag tagLocal = null;
        tagLocal = tagService.addTag(tag);

        if (tagLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(tagLocal, HttpStatus.OK);

    }

    @PutMapping("/tags/{tagId}")
    public ResponseEntity<Tag> updateTag(@PathVariable long tagId, @RequestBody Tag tag) {

        Tag tagLocal = tagService.updateTag(tagId, tag);

        if (tagLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(tagLocal, HttpStatus.OK);

    }

    @DeleteMapping("/tags/{tagId}")
    public ResponseEntity<Tag> deleteTag(@PathVariable long tagId) {
        tagService.deleteTag(tagId);
        return ResponseEntity.noContent().build();
    }


}
