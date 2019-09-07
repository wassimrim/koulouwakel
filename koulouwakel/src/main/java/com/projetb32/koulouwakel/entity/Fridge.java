package com.projetb32.koulouwakel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Target;
import java.util.*;


@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Fridge implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String name ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;

  /*  @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "fridge_ingredient",
            joinColumns = @JoinColumn(name = "fridge_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    List<Ingredient> fridgeIngredients = new ArrayList<Ingredient>();*/

//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.EAGER, cascade ={ CascadeType.MERGE})
//    @JoinTable(
//            joinColumns = {@JoinColumn(name = "fridge_id")},
//            inverseJoinColumns = {@JoinColumn(name = "ingredient_id")},
//            uniqueConstraints = {@UniqueConstraint(
//                    columnNames = {"fridge_id", "ingredient_id"})}
//    )
//    private List<Ingredient> fridgeIngredients = new ArrayList<>();
@OneToMany(fetch = FetchType.LAZY,mappedBy = "primaryKey.fridge" )

    private  Set<FridgeIngredientGroup>fridgeIngredientGroups = new HashSet<FridgeIngredientGroup>(0);


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Set<FridgeIngredientGroup> getFridgeIngredientGroups() {
        return fridgeIngredientGroups;
    }

    public void setFridgeIngredientGroups(Set<FridgeIngredientGroup> fridgeIngredientGroups) {
        this.fridgeIngredientGroups = fridgeIngredientGroups;
    }
}
