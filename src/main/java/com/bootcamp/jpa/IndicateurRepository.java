package com.bootcamp.jpa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.bootcamp.entities.Indicateur;

/**
 *
 * @author root
 */
public class IndicateurRepository extends BaseRepository<Indicateur>{
    
    public IndicateurRepository(String unitPersistence) {
        super(unitPersistence, Indicateur.class);
    }
    
}
