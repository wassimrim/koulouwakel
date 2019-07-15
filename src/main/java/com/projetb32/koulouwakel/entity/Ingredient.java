
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
public class Ingredient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String name ;

    private String unit_of_measure ;
    @ManyToOne
    @JoinColumn(name = "picture_id")
    private Picture picture ;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category ;
}