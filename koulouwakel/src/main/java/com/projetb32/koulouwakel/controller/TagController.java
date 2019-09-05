package com.projetb32.koulouwakel.controller;


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


    private static final Logger log = LoggerFactory.getLogger(TagController.class);

    @Autowired
    private TagService tagService;


    @GetMapping("/tags")
    public ResponseEntity<List<Tag>> retreiveTag() {

        if (tagService.getAllTag().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(tagService.getAllTag(), HttpStatus.OK);

    }

    @GetMapping("/tags/{tagId}")
    public ResponseEntity<Optional<Tag>> retreiveTagById(@PathVariable String tagId) {


        if (!tagService.getTagById(Long.parseLong(tagId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(tagService.getTagById(Long.parseLong(tagId)), HttpStatus.OK);
        }
    }

    @PostMapping("/tags")
    public ResponseEntity<Tag> addTag(@RequestBody Tag tag) {
        if (tag != null) {
            if (tagService.getTagByLabel(tag.getLabel()).isPresent()) {
                return ResponseEntity.noContent().build();
            }
        }
        //  log.info("affichage"+activite.getEvenement());
        Tag TagLocal = tagService.addTag(tag);

        if (TagLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(TagLocal, HttpStatus.OK);
        }
    }

    @PutMapping("/tags/{tagId}")
    public ResponseEntity<Tag> updateTag(@PathVariable String tagId, @RequestBody Tag tag) {

        if (tagService.getTagById(Long.parseLong(tagId)).isPresent()) {

            Tag TagLocal = tagService.updateTag(Long.parseLong(tagId), tag);

            if (TagLocal == null) {
                return ResponseEntity.noContent().build();
            } else {
                return new ResponseEntity<>(TagLocal, HttpStatus.OK);
            }
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @DeleteMapping("/tags/{tagId}")
    public ResponseEntity<Tag> deleteTag(@PathVariable String tagId) {

        if (tagService.getTagById(Long.parseLong(tagId)).isPresent()) {

            tagService.deleteTag(Long.parseLong(tagId));

			/*URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ActiviteId)
					.toUri();*/

            // Status

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }





}
