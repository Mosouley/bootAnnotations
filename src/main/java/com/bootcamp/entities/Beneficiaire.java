/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Archange
 */
@Entity
@DiscriminatorValue("BENEFICIAIRE")
@ApiModel(value="Beneficiaire Model",description="Beneficiaire Model witch is a Personne Model")
public class Beneficiaire extends Personne{
     private String description;

     
     public Beneficiaire(String  nom,String description){
     super(nom);
     this.description=description;
     }
     
     public Beneficiaire() {
		super();
	}
	public Beneficiaire(String nom) {
		super(nom);
	}

       
	@ApiModelProperty(value="Beneficiaire description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    
}
