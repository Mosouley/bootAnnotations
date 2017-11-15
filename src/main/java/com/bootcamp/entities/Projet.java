package com.bootcamp.entities;

import static com.bootcamp.AppConstants.PERSISTENCE_UNIT;
import com.bootcamp.enums.EtatsProjet;
import com.bootcamp.jpa.ProjetRepository;
import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import java.sql.SQLException;

@Entity
@Table(name = "rest_projet")
public class Projet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int idProgramme;
    
    private int idIndicateur;
    
    @NotNull(message="l'attribut nom doit etre renseigne")
    @Column(length = 30)
    private String nom;
    
    @NotNull(message="l'attribut reference doit etre renseigne")
    @Column(length = 50)
    private String reference;
    
    @NotNull(message="l'attribut Description doit etre renseigne")
    @Column(length = 255)
    private String description;
    
    @NotNull(message="l'attribut phaseActuelle doit etre renseigne")
    @Column(length = 50)
    private String phaseActuelle;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message="l'attribut dateDebutReelle doit etre renseigne")
    private Date dateDeDebutReelle;
    
    @NotNull(message="l'attribut dateFinReelle doit etre renseigne")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeFinReelle;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @NotNull(message="l'attribut dateDebutPrevisionnelle doit etre renseigne")
    private Date dateDeDebutPrevisionnelle;
    
    @NotNull(message="l'attribut dateFinPrevisionnelle doit etre renseigne")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDeFinPrevisionnelle;
    
    @NotNull(message="l'attribut budgetPrevisionnel doit etre renseigne")
    @Column(scale =2 )
    private double budgetPrevisionnel;
    
    @NotNull(message="l'attribut coutReel doit etre renseigne")
    @Column(scale = 2)
    private double coutReel;
    
    private EtatsProjet etat=EtatsProjet.PRE_ETUDE ;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projet")
    List<Impact> impacts = new ArrayList<Impact>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projet")
    private List<PhaseProjet> phaseProjet = new ArrayList<PhaseProjet>();

    public Projet(){
        this.nom = "defaultName";
        this.reference = "defaultreference";
        this.description = "defaultdescription";
        this.phaseActuelle = "defaultphaseActuelle";
        this.budgetPrevisionnel = 100.00;
        this.coutReel = 120.00;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProgramme() {
        return idProgramme;
    }

    public void setIdProgramme(int idProgramme) {
        this.idProgramme = idProgramme;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhaseActuelle() {
        return phaseActuelle;
    }

    public void setPhaseActuelle(String phaseActuelle) {
        this.phaseActuelle = phaseActuelle;
    }

    public Date getDateDeDebutReelle() {
        return dateDeDebutReelle;
    }

    public void setDateDeDebutReelle(Date dateDeDebutReelle) {
        this.dateDeDebutReelle = dateDeDebutReelle;
    }

    public Date getDateDeFinReelle() {
        return dateDeFinReelle;
    }

    public void setDateDeFinReelle(Date dateDeFinReelle) {
        this.dateDeFinReelle = dateDeFinReelle;
    }

    public Date getDateDeDebutPrevisionnelle() {
        return dateDeDebutPrevisionnelle;
    }

    public void setDateDeDebutPrevisionnelle(Date dateDeDebutPrevisionnelle) {
        this.dateDeDebutPrevisionnelle = dateDeDebutPrevisionnelle;
    }

    public Date getDateDeFinPrevisionnelle() {
        return dateDeFinPrevisionnelle;
    }

    public void setDateDeFinPrevisionnelle(Date dateDeFinPrevisionnelle) {
        this.dateDeFinPrevisionnelle = dateDeFinPrevisionnelle;
    }

    public double getBudgetPrevisionnel() {
        return budgetPrevisionnel;
    }

    public void setBudgetPrevisionnel(double budgetPrevisionnel) {
        this.budgetPrevisionnel = budgetPrevisionnel;
    }

    public double getCoutReel() {
        return coutReel;
    }

    public void setCoutReel(double coutReel) {
        this.coutReel = coutReel;
    }

    public EtatsProjet getEtat() {
        return etat;
    }

    public void setEtat(EtatsProjet etat) {
        this.etat = etat;
    }


    public List<Impact> getImpacts() {
        return impacts;
    }

    public void setImpacts(List<Impact> impacts) {
        this.impacts = impacts;
    }

    public int getIdIndicateur() {
        return idIndicateur;
    }

    public void setIdIndicateur(int idIndicateur) {
        this.idIndicateur = idIndicateur;
    }

    @Override
    public String toString() {
        return "Projet{" + "id=" + id + ", idProgramme=" + idProgramme + ", idIndicateur=" + idIndicateur + ", nom=" + nom + ", reference=" + reference + ", description=" + description + ", phaseActuelle=" + phaseActuelle + ", dateDeDebutReelle=" + dateDeDebutReelle + ", dateDeFinReelle=" + dateDeFinReelle + ", dateDeDebutPrevisionnelle=" + dateDeDebutPrevisionnelle + ", dateDeFinPrevisionnelle=" + dateDeFinPrevisionnelle + ", budgetPrevisionnel=" + budgetPrevisionnel + ", coutReel=" + coutReel + ", etat=" + etat + ", impacts=" + impacts + '}';
    }
 
    // methode qui verifie si l'instance actuelle existe deja dans la base de donnee
    public boolean isExist() throws SQLException{
        ProjetRepository pr = new ProjetRepository(PERSISTENCE_UNIT);
        
        List<Projet> pl = pr.findAll();
        
        for (Projet projet : pl) {
          if( this.description.equalsIgnoreCase(projet.getDescription()) && this.nom.equalsIgnoreCase(projet.getNom()) )
                return true;
        }
        return false;
    }

    /**
     * @return the phaseProjet
     */
    public List<PhaseProjet> getPhaseProjet() {
        return phaseProjet;
    }

    /**
     * @param phaseProjet the phaseProjet to set
     */
    public void setPhaseProjet(List<PhaseProjet> phaseProjet) {
        this.phaseProjet = phaseProjet;
    }
 
}
