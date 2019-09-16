package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.ConstraintTag;
import com.projetb32.koulouwakel.service.RestrictionService;
import com.projetb32.koulouwakel.service.RestrictiontagService;
import com.projetb32.koulouwakel.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/application")
public class RestrictionTagController {

    private static final Logger log = LoggerFactory.getLogger(RestrictionTagController.class);

    @Autowired
    private RestrictiontagService restrictiontagService;


    @GetMapping("/restrictiontags")
    public ResponseEntity<List<ConstraintTag>> retreiveRestrictionTags() {

        List<ConstraintTag> constraintTagList = null;
        constraintTagList = restrictiontagService.getAllRestrictionTag();
        if (constraintTagList.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(constraintTagList, HttpStatus.OK);

    }


    @PostMapping("/restrictiontags/{tagId}/{restrictionId}")
    public ResponseEntity<ConstraintTag> addRestrictionTag(@PathVariable long tagId, @PathVariable long restrictionId) {


        ConstraintTag restrictionLocal = restrictiontagService.addRestrictionTag(tagId, restrictionId);

        if (restrictionLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(restrictionLocal, HttpStatus.OK);

    }


    @DeleteMapping("/restrictiontags/{tagId}/{restrictionId}")
    public ResponseEntity<ConstraintTag> deleteRestrictionTag(@PathVariable long tagId, @PathVariable long restrictionId) {
        restrictiontagService.deleteRestrictionTag(tagId, restrictionId);
        return ResponseEntity.accepted().build();


    }


}
