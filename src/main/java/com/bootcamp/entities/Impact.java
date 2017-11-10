/**
 *
 * @Bignon
 */
package com.bootcamp.entities;

import static com.bootcamp.AppConstants.PERSISTENCE_UNIT;
import com.bootcamp.enums.TypesImpact;
import com.bootcamp.jpa.ImpactRepository;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rest_impact")
public class Impact implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull(message="l'attribut nom doit etre renseigne")
    @Column(length = 30)
    private String nom;
    
    @NotNull(message="l'attribut type doit etre renseigne")
    private TypesImpact type;
    
    @ManyToOne(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "projet_id", referencedColumnName = "id")
    private Projet projet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TypesImpact getType() {
        return type;
    }

    public void setType(TypesImpact type) {
        this.type = type;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    
    // methode qui verifie si l'instance actuelle existe deja dans la base de donnee 
    
    public boolean isExist() throws SQLException{
        ImpactRepository ir = new ImpactRepository(PERSISTENCE_UNIT);
        List<Impact> il = ir.findAll();
        
        for (Impact impact : il) {
            if(this.nom.equals(impact.getNom()) && this.type.equals(impact.getType()) ){
                return true;
            }
        }
        return false;
    }
}
