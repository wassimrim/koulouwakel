package com.projetb32.koulouwakel.entity;

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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

   private List<Ingredient> ingredients = new ArrayList<>();

    public Fridge(String name, User user, List<Ingredient> ingredients) {
        this.name = name;
        this.user = user;
        this.ingredients = ingredients;
    }
}
