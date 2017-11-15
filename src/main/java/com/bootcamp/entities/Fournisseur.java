/**
 * Repris par Moh parce qur non trouve sur le dernier depot git
 */
package com.bootcamp.entities;

import io.swagger.annotations.*;

import javax.persistence.*;

/**
 *
 * @author Ibrahim
 */
@Entity
@DiscriminatorValue("FOURNISSEUR")
@ApiModel(value = "Fournisseur Model", description = "Fournisseur Model witch is a Personne Model")
public class Fournisseur extends Personne {

    private static final long serialVersionUID = 1L;
    @Column(length = 45)
    private String pays;

    public Fournisseur() {
        super();
    }

    public Fournisseur(String nom) {
        super(nom);
    }

    public Fournisseur(String nom, String pays) {
        super(nom);
        this.pays = pays;
    }

    @ApiModelProperty(value = "The country of the Fournisseur")
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

}
