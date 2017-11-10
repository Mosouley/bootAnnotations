/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import com.bootcamp.enums.EtatProjet;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Iso-Doss
 */
@Entity(name = "ProjetIso")
@Table(name = "tp_projet_iso")
public class ProjetIso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Le champs nom ne peut etre null.")
    @Column(name = "nom", length = 45, nullable = false)
    private String nom;

    @NotNull(message = "Le champs description ne peut etre null.")
    @Column(name = "description", length = 45, nullable = false)
    private String description;

    @Column(name = "idObjectifs")
    private List<Integer> idObjectifs = new ArrayList<Integer>();

    @NotNull(message = "Le champs budgetPrevisionnel ne peut etre null.")
    @Column(nullable = false)
    private double budgetPrevisionnel;

    @NotNull(message = "Le champs budgetEffectif ne peut etre null.")
    @Column(nullable = false)
    private double budgetEffectif;

    @Column(name = "idImpacts")
    private List<Integer> idImpacts = new ArrayList<Integer>();

    @NotNull(message = "Le champs cout reel ne peut etre null.")
    @Column(name = "coutReel", nullable = false)
    private double coutReel;

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

    @Column(name = "idPhases")
    private List<Integer> idPhases = new ArrayList<Integer>();

    @Column(name = "idPhasesActuelle")
    private int idPhasesActuelle;

    @NotNull(message = "Le champ etat projet ne peut etre null.")
    @Column(name = "etatProjet", nullable = false)
    @Enumerated(EnumType.STRING)
    private EtatProjet etatProjet;

    @Column(name = "idProgramme")
    private int idProgramme;

    @Column(name = "idIndicateurPerformance")
    private int idIndicateurPerformance;

    @Column(name = "idLivrables")
    private List<Integer> idLivrables = new ArrayList<Integer>();

    @Column(name = "idFournisseurs")
    private List<Integer> idFournisseurs = new ArrayList<Integer>();

    @Column(name = "idBailleurs")
    private List<Integer> idBailleurs = new ArrayList<Integer>();

    @Column(name = "idBeneficiaires")
    private List<Integer> idBeneficiaires = new ArrayList<Integer>();

    public ProjetIso() {
    }

    public ProjetIso(int id, String nom, String description, double budgetPrevisionnel, double budgetEffectif, double coutReel, Date dateDebutPrevisionnelle, Date dateFinPrevisionnelle, Date dateDebutReelle, Date dateFinReelle, int idPhasesActuelle, EtatProjet etatProjet, int idProgramme, int idIndicateurPerformance) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.budgetPrevisionnel = budgetPrevisionnel;
        this.budgetEffectif = budgetEffectif;
        this.coutReel = coutReel;
        this.dateDebutPrevisionnelle = dateDebutPrevisionnelle;
        this.dateFinPrevisionnelle = dateFinPrevisionnelle;
        this.dateDebutReelle = dateDebutReelle;
        this.dateFinReelle = dateFinReelle;
        this.idPhasesActuelle = idPhasesActuelle;
        this.etatProjet = etatProjet;
        this.idProgramme = idProgramme;
        this.idIndicateurPerformance = idIndicateurPerformance;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjetIso)) {
            return false;
        }
        ProjetIso other = (ProjetIso) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bootcamp.entities.ProjetIso[ id=" + id + " ]";
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the idObjectifs
     */
    public List<Integer> getIdObjectifs() {
        return idObjectifs;
    }

    /**
     * @param idObjectifs the idObjectifs to set
     */
    public void setIdObjectifs(List<Integer> idObjectifs) {
        this.idObjectifs = idObjectifs;
    }

    /**
     * @return the budgetPrevisionnel
     */
    public double getBudgetPrevisionnel() {
        return budgetPrevisionnel;
    }

    /**
     * @param budgetPrevisionnel the budgetPrevisionnel to set
     */
    public void setBudgetPrevisionnel(double budgetPrevisionnel) {
        this.budgetPrevisionnel = budgetPrevisionnel;
    }

    /**
     * @return the budgetEffectif
     */
    public double getBudgetEffectif() {
        return budgetEffectif;
    }

    /**
     * @param budgetEffectif the budgetEffectif to set
     */
    public void setBudgetEffectif(double budgetEffectif) {
        this.budgetEffectif = budgetEffectif;
    }

    /**
     * @return the idImpacts
     */
    public List<Integer> getIdImpacts() {
        return idImpacts;
    }

    /**
     * @param idImpacts the idImpacts to set
     */
    public void setIdImpacts(List<Integer> idImpacts) {
        this.idImpacts = idImpacts;
    }

    /**
     * @return the coutReel
     */
    public double getCoutReel() {
        return coutReel;
    }

    /**
     * @param coutReel the coutReel to set
     */
    public void setCoutReel(double coutReel) {
        this.coutReel = coutReel;
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

    /**
     * @return the idPhases
     */
    public List<Integer> getIdPhases() {
        return idPhases;
    }

    /**
     * @param idPhases the idPhases to set
     */
    public void setIdPhases(List<Integer> idPhases) {
        this.idPhases = idPhases;
    }

    /**
     * @return the idPhasesActuelle
     */
    public int getIdPhasesActuelle() {
        return idPhasesActuelle;
    }

    /**
     * @param idPhasesActuelle the idPhasesActuelle to set
     */
    public void setIdPhasesActuelle(int idPhasesActuelle) {
        this.idPhasesActuelle = idPhasesActuelle;
    }

    /**
     * @return the etatProjet
     */
    public EtatProjet getEtatProjet() {
        return etatProjet;
    }

    /**
     * @param etatProjet the etatProjet to set
     */
    public void setEtatProjet(EtatProjet etatProjet) {
        this.etatProjet = etatProjet;
    }

    /**
     * @return the idProgramme
     */
    public int getIdProgramme() {
        return idProgramme;
    }

    /**
     * @param idProgramme the idProgramme to set
     */
    public void setIdProgramme(int idProgramme) {
        this.idProgramme = idProgramme;
    }

    /**
     * @return the idIndicateurPerformance
     */
    public int getIdIndicateurPerformance() {
        return idIndicateurPerformance;
    }

    /**
     * @param idIndicateurPerformance the idIndicateurPerformance to set
     */
    public void setIdIndicateurPerformance(int idIndicateurPerformance) {
        this.idIndicateurPerformance = idIndicateurPerformance;
    }

    /**
     * @return the idLivrables
     */
    public List<Integer> getIdLivrables() {
        return idLivrables;
    }

    /**
     * @param idLivrables the idLivrables to set
     */
    public void setIdLivrables(List<Integer> idLivrables) {
        this.idLivrables = idLivrables;
    }

    /**
     * @return the idFournisseurs
     */
    public List<Integer> getIdFournisseurs() {
        return idFournisseurs;
    }

    /**
     * @param idFournisseurs the idFournisseurs to set
     */
    public void setIdFournisseurs(List<Integer> idFournisseurs) {
        this.idFournisseurs = idFournisseurs;
    }

    /**
     * @return the idBailleurs
     */
    public List<Integer> getIdBailleurs() {
        return idBailleurs;
    }

    /**
     * @param idBailleurs the idBailleurs to set
     */
    public void setIdBailleurs(List<Integer> idBailleurs) {
        this.idBailleurs = idBailleurs;
    }

    /**
     * @return the idBeneficiaires
     */
    public List<Integer> getIdBeneficiaires() {
        return idBeneficiaires;
    }

    /**
     * @param idBeneficiaires the idBeneficiaires to set
     */
    public void setIdBeneficiaires(List<Integer> idBeneficiaires) {
        this.idBeneficiaires = idBeneficiaires;
    }

}
