package com.projetb32.koulouwakel.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Category implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "parent_id")
    private Category parentCategory;

    @JsonIgnore
    @OneToMany(mappedBy = "parentCategory")
    private Set<Category> subCategorys = new HashSet<Category>();


    private String type ;


}
