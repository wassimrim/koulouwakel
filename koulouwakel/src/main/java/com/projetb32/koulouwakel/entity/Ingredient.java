
package com.projetb32.koulouwakel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String name ;

    private String unit_of_measure ;
   // @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "picture_id")
    private Picture picture ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category ;

// relation  one to many  with firdgeIngredientId
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "primaryKey.ingredient")
    private  Set<FridgeIngredientGroup>fridgeIngredientGroups = new HashSet<FridgeIngredientGroup>(0);

//    @JsonIgnore
//    @ManyToMany(mappedBy = "fridgeIngredients")
//    List<Fridge> fridges;


    public Set<FridgeIngredientGroup> getFridgeIngredientGroups() {
        return fridgeIngredientGroups;
    }

    public void setFridgeIngredientGroups(Set<FridgeIngredientGroup> fridgeIngredientGroups) {
        this.fridgeIngredientGroups = fridgeIngredientGroups;
    }
}

