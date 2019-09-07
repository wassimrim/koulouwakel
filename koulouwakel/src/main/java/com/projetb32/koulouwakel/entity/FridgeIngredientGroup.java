package com.projetb32.koulouwakel.entity;


import javax.persistence.*;
import java.util.Date;

@Entity

public class FridgeIngredientGroup {

    @EmbeddedId
    private FridgeIngredientId primaryKey = new FridgeIngredientId();

    private Integer quantityIngredient ;
    private Date dateExperationIngredient ;

    public FridgeIngredientId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(FridgeIngredientId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Integer getQuantityIngredient() {
        return quantityIngredient;
    }

    public void setQuantityIngredient(Integer quantityIngredient) {
        this.quantityIngredient = quantityIngredient;
    }

    public Date getDateExperationIngredient() {
        return dateExperationIngredient;
    }

    public void setDateExperationIngredient(Date dateExperationIngredient) {
        this.dateExperationIngredient = dateExperationIngredient;
    }
    @Transient
    public Fridge getFridge(){
        return getPrimaryKey().getFridge();
    }
    @Transient
    public Ingredient getIngredient(){
        return getPrimaryKey().getIngredient();
    }

    public void setFridge(Fridge fridge){
        getPrimaryKey().setFridge(fridge);
    }
    public void setIngredient (Ingredient ingredient){
        getPrimaryKey().setIngredient(ingredient);
    }

}
