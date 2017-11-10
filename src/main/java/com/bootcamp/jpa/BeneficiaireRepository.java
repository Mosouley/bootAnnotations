/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa;

import com.bootcamp.entities.Beneficiaire;

/**
 *
 * @author Archange
 */
public class BeneficiaireRepository extends BaseRepository<Beneficiaire>{

    public BeneficiaireRepository(String persistUnit) {
        super(persistUnit, Beneficiaire.class);
    }
    
}
