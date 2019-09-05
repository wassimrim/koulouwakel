package com.projetb32.koulouwakel.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConstraintCategory {



    @EmbeddedId
    protected ConstraintCategoryPk constraintCategoryPk ;

}


