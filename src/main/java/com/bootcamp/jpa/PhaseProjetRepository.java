
package com.bootcamp.jpa;

import com.bootcamp.entities.*;

public class PhaseProjetRepository extends BaseRepository<PhaseProjet>{
  
    public PhaseProjetRepository(String unitPersistence) {
        super(unitPersistence, Projet.class);
    }
}
