/*<<<<<<< HEAD
=======
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
    private int id ;

    private String name ;

    private String unitofmeasure ;
    @ManyToOne
    @JoinColumn(name = "picture_id")
    private Picture picture ;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category ;
}
>>>>>>> 9a9e2f5e239b1efd81a0765b35a11afe5453120a*/
