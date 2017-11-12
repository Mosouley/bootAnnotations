/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Iso-Doss
 */
@Entity
public class PhaseProjet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "Le champs nom ne peut etre null.")
    @Column(name = "nom", length = 45, nullable = false)
    private String nom;

    @NotNull(message = "Le champs date debut previsionnelle ne peut etre null.")
    @Column(name = "dateDebutPrevisionnelle", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebutPrevisionnelle;

    @NotNull(message = "Le champs date fin previsionnelle ne peut etre null.")
    @Column(name = "dateFinPrevisionnelle", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFinPrevisionnelle;

    @NotNull(message = "Le champs date debut reelle ne peut etre null.")
    @Column(name = "dateDebutReelle", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebutReelle;

    @NotNull(message = "Le champs date fin reelle ne peut etre null.")
    @Column(name = "dateFinReelle", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFinReelle;

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
        if (!(object instanceof PhaseProjet)) {
            return false;
        }
        PhaseProjet other = (PhaseProjet) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.bootcamp.jpa.entities.PhaseProjet[ id=" + id + " ]";
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
     * @return the dateDebutPrevisionnelle
     */
    public Date getDateDebutPrevisionnelle() {
        return dateDebutPrevisionnelle;
    }

    /**
     * @param dateDebutPrevisionnelle the dateDebutPrevisionnelle to set
     */
    public void setDateDebutPrevisionnelle(Date dateDebutPrevisionnelle) {
        this.dateDebutPrevisionnelle = dateDebutPrevisionnelle;
    }

    /**
     * @return the dateFinPrevisionnelle
     */
    public Date getDateFinPrevisionnelle() {
        return dateFinPrevisionnelle;
    }

    /**
     * @param dateFinPrevisionnelle the dateFinPrevisionnelle to set
     */
    public void setDateFinPrevisionnelle(Date dateFinPrevisionnelle) {
        this.dateFinPrevisionnelle = dateFinPrevisionnelle;
    }

    /**
     * @return the dateDebutReelle
     */
    public Date getDateDebutReelle() {
        return dateDebutReelle;
    }

    /**
     * @param dateDebutReelle the dateDebutReelle to set
     */
    public void setDateDebutReelle(Date dateDebutReelle) {
        this.dateDebutReelle = dateDebutReelle;
    }

    /**
     * @return the dateFinReelle
     */
    public Date getDateFinReelle() {
        return dateFinReelle;
    }

    /**
     * @param dateFinReelle the dateFinReelle to set
     */
    public void setDateFinReelle(Date dateFinReelle) {
        this.dateFinReelle = dateFinReelle;
    }

}
