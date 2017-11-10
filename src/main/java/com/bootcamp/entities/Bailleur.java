/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import io.swagger.annotations.*;

import javax.persistence.*;

/**
 *
 * @author Ibrahim
 */
@Entity
@Table(name = "tp_bailleur")
@DiscriminatorValue("BAILLEUR")
@ApiModel(value = "Bailleur Model", description = "Bailleur Model witch is a Personne Model")
public class Bailleur extends Personne {

    private static final long serialVersionUID = 1L;
    @Column(length = 45)
    private String pays;

    public Bailleur() {
        super();
    }

    public Bailleur(String nom) {
        super(nom);
    }

    public Bailleur(String nom, String pays) {
        super(nom);
        this.pays = pays;
    }

    @ApiModelProperty(value = "The country of the Bailleur")
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    /*  @OneToMany
  private List<Bailleur_has_Programme> bailleur_has_programme = new ArrayList<Bailleur_has_Programme>();
  @OneToMany
 private List<Bailleur_has_Projet> bailleurHasProjet = new ArrayList<Bailleur_has_Projet>();*/
}
