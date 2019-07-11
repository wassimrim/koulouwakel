package com.projetb32.koulouwakel.entity;

import javax.persistence.*;
import java.io.Serializable;

public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category ;
}
