package com.projetb32.koulouwakel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConstraintTagPk implements Serializable {

    @ManyToOne(optional = false, fetch = FetchType.EAGER , cascade= CascadeType.ALL)
    @JoinColumn(name = "tag_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Tag tag ;

    @ManyToOne(optional = false, fetch = FetchType.EAGER , cascade= CascadeType.ALL)
    @JoinColumn(name = "constraint_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Restriction restriction;


}
