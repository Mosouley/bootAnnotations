package com.bootcamp.jpa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.bootcamp.entities.Commune;

/**
 *
 * @author root
 */
public class CommuneRepository extends BaseRepository<Commune>{
    
    public CommuneRepository(String unitPersistence) {
        super(unitPersistence, Commune.class);
    }
    
}
