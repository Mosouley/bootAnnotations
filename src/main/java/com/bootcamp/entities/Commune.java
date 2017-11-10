/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Link;

/**
 *
 * @author Bello
 */
@Entity
@Table(name = "rest_commune")
@ApiModel(value = "Commune",
        description = "representation d'une signature Commune")
public class Commune implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Id de la Commune", required = true)
    private int id;

    @NotNull(message = "l'attribut nom doit ne peut etre vide")
    @Column(nullable = false, length = 30)
    @ApiModelProperty(value = "nom de la commune", required = true)
    private String nom;

    @NotNull(message = "l'attribut longitude ne peut etre vide")
    @Column(nullable = false)
    @ApiModelProperty(value = "longitude de la commune", required = true)
    private double longitude;

    @NotNull(message = "l'attribut latitude ne peut etre vide")
    @Column(nullable = false)
    @ApiModelProperty(value = "latitude de la commune", required = true)
    private double latitude;

    @ManyToOne
    @JoinColumn(name = "departement", referencedColumnName = "id", insertable = false, updatable = false)
    Departement departement;

    @Transient
    private Link self;

    public Commune() {
    }

    public Commune(int id, String nom, double longitude, double latitude) {
        this.id = id;
        this.nom = nom;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Commune(String nom, double longitude, double latitude) {
        this.nom = nom;
        this.longitude = longitude;
        this.latitude = latitude;
    }

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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitud(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
