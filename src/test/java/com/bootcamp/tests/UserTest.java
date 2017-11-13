/**
 *
 * @Bignon
 */
package com.bootcamp.tests;

import com.bootcamp.AppConstants;
import com.bootcamp.entities.Projet;
import com.bootcamp.jpa.ProjetRepository;
import java.sql.SQLException;
import java.util.List;
import org.testng.annotations.Test;

public class ProjetTest {
    ProjetRepository pr = new ProjetRepository(AppConstants.PERSISTENCE_UNIT);
    
    @Test
    public void create() throws SQLException{
     Projet projet = new Projet();     
     pr.create(projet);
     
     projet.setNom("nom1");
     pr.create(projet);
     
     projet.setNom("nom2");
     projet.setReference("ref1");
     pr.create(projet);
    }
    
     public void update() throws SQLException{
     Projet projet = pr.findByPropertyUnique("id", 3);
     projet.setReference("ref2");
     pr.update(projet);
    }
     
    public void delete() throws SQLException{
     Projet projet = pr.findByPropertyUnique("id", 2);
     pr.delete(projet);
    }
    
     public void findall() throws SQLException{
     List<Projet> projets = pr.findAll();
    }
}
