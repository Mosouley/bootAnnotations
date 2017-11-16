package com.bootcamp.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Ibrahim
 */
@Entity
@Table(name="tp_bailleur")
@DiscriminatorValue("BAILLEUR")
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
