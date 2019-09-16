package com.projetb32.koulouwakel.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.codehaus.jackson.annotate.JsonBackReference;

import org.codehaus.jackson.annotate.JsonManagedReference;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Family implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    @ManyToOne(cascade = { CascadeType.DETACH })
    @JoinColumn(name = "parent_id")
    private Family parentFamily;

    @JsonIgnore
    @OneToMany(mappedBy = "parentFamily")
    private Set<Family> subFamilys = new HashSet<Family>();

    private String name ;





}
