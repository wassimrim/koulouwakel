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
    private FamilyService familyService ;


    @GetMapping("/familys")
    public ResponseEntity<List<Family>> retreiveFamily() {

        if (familyService.getAllFamily().isEmpty())
            return ResponseEntity.noContent().build();

        return new ResponseEntity<>(familyService.getAllFamily(), HttpStatus.OK);

    }

    @GetMapping("/familys/{familyId}")
    public ResponseEntity<Optional<Family>> retreiveFamilyById(@PathVariable String familyId) {


        if (!familyService.getFamilyById(Long.parseLong(familyId)).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(familyService.getFamilyById(Long.parseLong(familyId)), HttpStatus.OK);
        }
    }


    @GetMapping("/familys/{familyName}")
    public ResponseEntity<Optional<Family>> retreiveFamilyByName(@PathVariable String familyName) {


        if (!familyService.getFamilyByName(familyName).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(familyService.getFamilyByName(familyName), HttpStatus.OK);
        }
    }

    @GetMapping("/familys/{parentfamily}")
    public ResponseEntity<Optional<Family>> retreiveFamilyByParentFamily(@PathVariable String parentFamily) {


        if (!familyService.getFamilysByParentFamily(parentFamily).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(familyService.getFamilysByParentFamily(parentFamily), HttpStatus.OK);
        }
    }




    @PostMapping("/familys/{id}")
    public ResponseEntity<Family> addFamily(@RequestBody Family family,@PathVariable Long id) {
        Family parentFamily =null;
        if (family != null) {
            parentFamily= familyService.getFamilyById(id).get();
            if (familyService.getFamilyByName(family.getName()).isPresent() || parentFamily == null) {
                return ResponseEntity.noContent().build();
            }
        }
            family.setParentFamily(parentFamily);
        Family familyLocal = familyService.addFamily(family);

        if (familyLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(familyLocal, HttpStatus.OK);
        }
    }

    @PostMapping("/familys")
    public ResponseEntity<Family> addFamily(@RequestBody Family family) {

        if (family != null) {

            if (familyService.getFamilyByName(family.getName()).isPresent() ) {
                return ResponseEntity.noContent().build();
            }
        }
        Family familyLocal = familyService.addFamily(family);

        if (familyLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(familyLocal, HttpStatus.OK);
        }
    }


    @DeleteMapping("/familys/{familyId}")
    public ResponseEntity<Family> deleteFamily(@PathVariable String familyId) {

        if (familyService.getFamilyById(Long.parseLong(familyId)).isPresent()) {

            familyService.deleteFamily(Long.parseLong(familyId));

            return ResponseEntity.accepted().build();

        } else {
            return ResponseEntity.noContent().build();
        }
    }





}
