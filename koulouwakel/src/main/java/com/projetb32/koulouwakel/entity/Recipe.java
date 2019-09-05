package com.projetb32.koulouwakel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Recipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String title ;

    private LocalTime prepDuration ;

    private int nbPerson ;

    private String difficulty ;

    private String country ;

    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family ;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;


}
