/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.tests;

import static com.bootcamp.AppConstants.PERSISTENCE_UNIT;
import com.bootcamp.jpa.DepartementRepository;
import com.bootcamp.entities.Commune;
import com.bootcamp.entities.Departement;
import java.sql.SQLException;
import java.util.ArrayList;
import org.testng.annotations.Test;

/**
 *
 * @author Bello
 */
public class DepartementTest {
    @Test
    public void createDepartements() throws SQLException{
        Departement dep = new Departement("Zou", 22, 2.066520, 7.346927);
        
        Commune com1 = new Commune ("Bohicon", 2.0667000, 7.1782600);
        Commune com2 = new Commune ("Abomey", 1.9911900, 7.1828600);
        Commune com3 = new Commune ("Zogbodomey", 2.0999996, 7.083333);
        
        ArrayList listCommune = new ArrayList();
        listCommune.add(com1);
        listCommune.add(com2);
        listCommune.add(com3);
        
        dep.setCommuneList(listCommune);

        DepartementRepository depRep = new DepartementRepository(PERSISTENCE_UNIT);
        
        depRep.create(dep);
    }
    
    @Test
    public void getDepartements() throws SQLException{
        DepartementRepository depRep = new DepartementRepository(PERSISTENCE_UNIT);
        
        System.out.println(depRep.findAll());
    }
}
