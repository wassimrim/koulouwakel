package com.projetb32.koulouwakel.controller;

import com.projetb32.koulouwakel.entity.Restriction;
import com.projetb32.koulouwakel.service.RestrictionService;
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
public class RestrictionController {


    private static final Logger log = LoggerFactory.getLogger(RestrictionController.class);

    @Autowired
    private RestrictionService restrictionService;


    @GetMapping("/restrictions")
    public ResponseEntity<List<Restriction>> retreiveRestriction() {
        List<Restriction> restrictionList = null;
        restrictionList = restrictionService.getAllRestriction();

        if (restrictionList.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(restrictionList, HttpStatus.OK);

    }

    @GetMapping("/restrictions/{restrictionId}")
    public ResponseEntity<Optional<Restriction>> retreiveRestrictionById(@PathVariable long restrictionId) {

        Optional<Restriction> restrictionList = null;
        restrictionList = restrictionService.getRestrictionById(restrictionId);
        if (!restrictionList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(restrictionList, HttpStatus.OK);

    }

    @PostMapping("/restrictions")
    public ResponseEntity<Restriction> addRestriction(@RequestBody Restriction restriction) {

        Restriction RestrictionLocal = restrictionService.addRestriction(restriction);

        if (RestrictionLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(RestrictionLocal, HttpStatus.OK);
    }


    @PutMapping("/restrictions/{restrictionId}")
    public ResponseEntity<Restriction> updateRestriction(@PathVariable long restrictionId, @RequestBody Restriction restriction) {

        Restriction RestrictionLocal = restrictionService.updateTag(restrictionId, restriction);

        if (RestrictionLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(RestrictionLocal, HttpStatus.OK);
    }


    @DeleteMapping("/restrictions/{restrictionId}")
    public ResponseEntity<Restriction> deleteRestriction(@PathVariable long restrictionId) {
        restrictionService.deleteTag(restrictionId);
        return ResponseEntity.accepted().build();
    }
}
