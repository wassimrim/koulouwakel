package com.projetb32.koulouwakel.controller;


import com.projetb32.koulouwakel.entity.ConstraintUser;
import com.projetb32.koulouwakel.service.RestrictionService;
import com.projetb32.koulouwakel.service.RestrictionUserService;
import com.projetb32.koulouwakel.service.UserPrinciple;
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
public class RestrictionUserController {


    private static final Logger log = LoggerFactory.getLogger(RestrictionCategoryController.class);




    @Autowired
    private RestrictionUserService restrictionUserService;

    @GetMapping("/restrictionuser")
    public ResponseEntity<List<ConstraintUser>> retreiveRestrictionUsers() {
        List<ConstraintUser> constraintUserList = null;
        constraintUserList = restrictionUserService.getAllRestrictionUser();
        if (constraintUserList.isEmpty())
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(constraintUserList, HttpStatus.OK);
    }


    @PostMapping("/restrictionuser/{userId}/{restrictionId}")
    public ResponseEntity<ConstraintUser> addRestrictionUser(@PathVariable long userId, @PathVariable long restrictionId) {


        ConstraintUser restrictionLocal = restrictionUserService.addRestrictionUser(userId, restrictionId);

        if (restrictionLocal == null)
            return ResponseEntity.noContent().build();
        return new ResponseEntity<>(restrictionLocal, HttpStatus.OK);

    }


    @DeleteMapping("/restrictionuser/{userId}/{restrictionId}")
    public ResponseEntity<ConstraintUser> deleteRestrictionUser(@PathVariable long userId, @PathVariable long restrictionId) {
        restrictionUserService.deleteRestrictionUser(userId, restrictionId);
        return ResponseEntity.accepted().build();


    }


}
