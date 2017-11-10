
package com.bootcamp.jpa;

import com.bootcamp.entities.Impact;

public class ImpactRepository extends BaseRepository<Impact>{
  
    public ImpactRepository(String unitPersistence) {
        super(unitPersistence, Impact.class);
    }
}
