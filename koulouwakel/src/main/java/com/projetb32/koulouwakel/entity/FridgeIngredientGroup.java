package com.projetb32.koulouwakel.entity;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity

public class FridgeIngredientGroup {

    @EmbeddedId
    private FridgeIngredientId primaryKey ;

    private int quantityIngredient ;
    private LocalDate dateExperationIngredient ;

    public FridgeIngredientGroup() {
    }

    public FridgeIngredientGroup(FridgeIngredientId primaryKey, int quantityIngredient, LocalDate dateExperationIngredient) {
        this.primaryKey = primaryKey;
        this.quantityIngredient = quantityIngredient;
        this.dateExperationIngredient = dateExperationIngredient;
    }
    public FridgeIngredientGroup(FridgeIngredientId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public FridgeIngredientId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(FridgeIngredientId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public int getQuantityIngredient() {
        return quantityIngredient;
    }

    public void setQuantityIngredient(int quantityIngredient) {
        this.quantityIngredient = quantityIngredient;
    }

    public LocalDate getDateExperationIngredient() {
        return dateExperationIngredient;
    }

    public void setDateExperationIngredient(LocalDate dateExperationIngredient) {
        this.dateExperationIngredient = dateExperationIngredient;
    }

  /*  @Transient
    public Fridge getFridge(){
        return getPrimaryKey().getFridge();
    }
    @Transient
    public Ingredient getIngredient(){
        return getPrimaryKey().getIngredient();
    }*/

    public void setFridge(Fridge fridge){
        getPrimaryKey().setFridge(fridge);
    }
    public void setIngredient (Ingredient ingredient){
        getPrimaryKey().setIngredient(ingredient);
    }

}
