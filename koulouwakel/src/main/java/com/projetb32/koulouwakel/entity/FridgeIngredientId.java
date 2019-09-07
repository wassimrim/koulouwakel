package com.projetb32.koulouwakel.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class FridgeIngredientId implements Serializable {

    @ManyToOne(optional = false, fetch = FetchType.EAGER , cascade= CascadeType.ALL)
    @JoinColumn(name = "fridge_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Fridge fridge ;
    @ManyToOne(optional = false, fetch = FetchType.EAGER , cascade= CascadeType.ALL)
    @JoinColumn(name = "ingredient_id", referencedColumnName = "id", insertable = false, updatable = false)
    private  Ingredient ingredient ;


    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }


    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
