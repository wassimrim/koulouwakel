package com.projetb32.koulouwakel.controller;

import com.projetb32.koulouwakel.entity.Family;
import com.projetb32.koulouwakel.service.FamilyService;
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
public class FamilyController {
    private static final Logger log = LoggerFactory.getLogger(FamilyController.class);

    @Autowired
    private FamilyService familyService;


    @GetMapping("/familys")
    public ResponseEntity<List<Family>> retreiveFamily() {

        List<Family> familyList = null;
        familyList = familyService.getAllFamily();
        if (familyList.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(familyService.getAllFamily(), HttpStatus.OK);

    }

    @GetMapping("/familys/{familyId}")
    public ResponseEntity<Optional<Family>> retreiveFamilyById(@PathVariable long familyId) {
        Optional<Family> familyList = null;
        familyList = familyService.getFamilyById(familyId);
        if (!familyList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(familyList, HttpStatus.OK);
    }


    @GetMapping("/familys/familyname/{familyName}")
    public ResponseEntity<Optional<Family>> retreiveFamilyByName(@PathVariable String familyName) {

        Optional<Family> familyList = null;
        familyList = familyService.getFamilyByName(familyName);

        if (!familyList.isPresent())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(familyList, HttpStatus.OK);

    }

    @PostMapping("/familys/{familyId}")
    public ResponseEntity<Family> addFamily(@RequestBody Family family,@PathVariable long familyId) {
      Family familyObject = familyService.getFamilyById(familyId).get();
        family.setParentFamily(familyObject);
        Family familyLocal = familyService.addFamily(family);
        return new ResponseEntity<>(familyLocal, HttpStatus.OK);

    }

    @DeleteMapping("/familys/{familyId}")
    public ResponseEntity<Family> deleteFamily(@PathVariable long familyId) {
        familyService.deleteFamily(familyId);
        return ResponseEntity.accepted().build();
    }


}
