package com.bootcamp.tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 
import com.bootcamp.entities.Indicateur;
import com.bootcamp.enums.TypeIndicateur;
import com.bootcamp.jpa.IndicateurRepository;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import org.testng.annotations.Test;

/**
 *
 * @author root
 */
public class IndicateurTester {
    
       @Test
       public void generateTables(){
           
           Persistence.generateSchema("databasePU", new Properties());
       }
        @Test
        public void tester(){
            IndicateurRepository ir = new IndicateurRepository("databasePU");
            Indicateur indicateur1 = new Indicateur("libelle1" , "nom1" , "nature1" , "propriete1" , TypeIndicateur.QUALITATIF , "valeur1" );
            Indicateur indicateur2 = new Indicateur("libelle2" , "nom2" , "nature2" , "propriete2" , TypeIndicateur.QUANTITATIF , "valeur2" );
            Indicateur indicateur3 = new Indicateur("libelle3" , "nom3" , "nature3" , "propriete3" , TypeIndicateur.QUALITATIF , "valeur3" );
            Indicateur indicateur4 = new Indicateur("libelle4" , "nom4" , "nature4" , "propriete4" , TypeIndicateur.QUANTITATIF , "valeur4" );
            Indicateur indicateur5= new Indicateur("libelle5" , "nom5" , "nature5" , "propriete5" , TypeIndicateur.QUALITATIF , "valeur5");
           try {
               ir.create(indicateur1);
               ir.create(indicateur2);
               ir.create(indicateur3);
               ir.create(indicateur4);
               ir.create(indicateur5);
           } catch (SQLException ex) {
               Logger.getLogger(IndicateurTester.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
}
