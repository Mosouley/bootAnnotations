/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import com.bootcamp.enums.TypeImapct;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "ImpactProjetIso")
@Table(name = "tp_impact_projet_iso")
public class ImpactProjetIso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Le champs nom ne peut etre null.")
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull(message = "Le champ type d'impact ne peut etre null.")
    @Column(name = "typeDeImpact", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeImapct typeImapct;

    public ImpactProjetIso() {
    }

    public ImpactProjetIso(Long id, String nom, TypeImapct typeImapct) {
        this.id = id;
        this.nom = nom;
        this.typeImapct = typeImapct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ImpactProjetIso)) {
            return false;
        }
        ImpactProjetIso other = (ImpactProjetIso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.entities.ImpactProjetIso[ id=" + id + " ]";
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the typeImapct
     */
    public TypeImapct getTypeImapct() {
        return typeImapct;
    }

    /**
     * @param typeImapct the typeImapct to set
     */
    public void setTypeImapct(TypeImapct typeImapct) {
        this.typeImapct = typeImapct;
    }

}
