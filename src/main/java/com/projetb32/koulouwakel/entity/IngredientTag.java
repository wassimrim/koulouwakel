package com.projetb32.koulouwakel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredientTag   {

    @EmbeddedId
    protected IngredientTagPk ingredientTagPk ;




}
