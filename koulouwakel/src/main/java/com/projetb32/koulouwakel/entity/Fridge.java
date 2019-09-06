package com.projetb32.koulouwakel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fridge implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String name ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "fridge_ingredient",
            joinColumns = @JoinColumn(name = "fridge_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    List<Ingredient> fridgeIngredients = new ArrayList<Ingredient>();


  /*  @ManyToMany(fetch = FetchType.EAGER, cascade ={ CascadeType.MERGE})
    @JoinTable(
            joinColumns = {@JoinColumn(name = "firdge_id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")},
            uniqueConstraints = {@UniqueConstraint(
                    columnNames = {"firdge_id", "ingredient_id"})}
    )
    private List<Ingredient> ingredients = new ArrayList<>();*/





}
