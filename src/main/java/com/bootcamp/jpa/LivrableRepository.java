/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.jpa;

import com.bootcamp.entities.Livrable;

/**
 *
 * @author leger
 */
public class LivrableRepository extends BaseRepository<Livrable> {

    public LivrableRepository(String persistUnit) {
        super(persistUnit, Livrable.class);
    }
}
