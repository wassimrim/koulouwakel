package com.projetb32.koulouwakel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instruction implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String Description ;

    private int quantity ;

    @ManyToOne
    @JoinColumn(name = "step_id")
    private Step step ;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient ;
}
