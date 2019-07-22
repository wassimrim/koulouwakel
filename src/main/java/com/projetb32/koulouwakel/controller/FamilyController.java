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


    @GetMapping("/familys/{familyType}")
    public ResponseEntity<Optional<Family>> retreiveFamilyByType(@PathVariable String familyType) {


        if (!familyService.getFamilyBytype(familyType).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(familyService.getFamilyBytype(familyType), HttpStatus.OK);
        }
    }

    @GetMapping("/familys/{familyparent}")
    public ResponseEntity<Optional<Family>> retreiveFamilyByParent(@PathVariable String familyparent) {


        if (!familyService.getFamilyByParent(familyparent).isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(familyService.getFamilyByParent(familyparent), HttpStatus.OK);
        }
    }




    @PostMapping("/familys")
    public ResponseEntity<Family> addFamily(@RequestBody Family family) {
        if (family != null) {
            if (familyService.getFamilyBytype(family.getName()).isPresent()) {
                return ResponseEntity.noContent().build();
            }
        }
        //  log.info("affichage"+activite.getEvenement());
        Family categoryLocal = familyService.addFamily(family);

        if (categoryLocal == null) {
            return ResponseEntity.noContent().build();
        } else {
            return new ResponseEntity<>(categoryLocal, HttpStatus.OK);
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
