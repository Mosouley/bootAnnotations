/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import com.bootcamp.enums.TypeIndicateur;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author root
 */
@Entity
@Table(name = "service_indicateur")
@ApiModel(value="Indicateur",description="représentation d'une resource REST Livrable")
public class Indicateur implements Serializable {
    @Id
    @ApiModelProperty(value="id indicateur", required=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false,length = 45)
    @ApiModelProperty(value="libelle indicateur", required=true)
    private String libelle;
    @ApiModelProperty(value="nom dindicateur", required=true)
    @Column(nullable = false,length = 45)
    private String nom;
    @ApiModelProperty(value="nature indicateur", required=true)
    @Column(nullable = false,length = 45)
    private String nature;
    @ApiModelProperty(value="propriete indicateur", required=true)
    @Column(nullable = false,length = 45)
    private String propriete;
    @ApiModelProperty(value="type indicateur ", required=true)
    @Column(nullable = false,length = 45)
    private TypeIndicateur typeIndicateur;
    @ApiModelProperty(value="dvaleur indicateur", required=true)
    @Column(nullable = false,length = 45)
    private String valeur;

    public Indicateur() {
    }

    public Indicateur( String libelle, String nom, String nature, String propriete, TypeIndicateur typeIndicateur, String valeur) {
        this.libelle = libelle;
        this.nom = nom;
        this.nature = nature;
        this.propriete = propriete;
        this.typeIndicateur = typeIndicateur;
        this.valeur = valeur;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getPropriete() {
        return propriete;
    }

    public void setPropriete(String propriete) {
        this.propriete = propriete;
    }

    public TypeIndicateur getTypeIndicateur() {
        return typeIndicateur;
    }

    public void setTypeIndicateur(TypeIndicateur typeIndicateur) {
        this.typeIndicateur = typeIndicateur;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @Override
    public String toString() {
        return "Indicateur{" + "id=" + id + ", libelle=" + libelle + ", nature=" + nature + ", propriete=" + propriete + ", typeIndicateur=" + typeIndicateur + ", valeur=" + valeur + '}';
    }
    
    
}
