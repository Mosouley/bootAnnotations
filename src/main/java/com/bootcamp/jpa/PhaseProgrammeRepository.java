/**
 * implementation du repository sur PhaseProgramme
 * classe heritant du baserepository
 * gardons l'unite de persitance en variable pour pouvoir la modifier
 * a tout moment
 */
package com.bootcamp.jpa;

import com.bootcamp.entities.PhaseProgramme;



/**
 *
 * @author soul
 */
public class PhaseProgrammeRepository extends BaseRepository<PhaseProgramme> {
public PhaseProgrammeRepository(String persistUnit) {
        super(persistUnit,PhaseProgramme.class);
    }
}
