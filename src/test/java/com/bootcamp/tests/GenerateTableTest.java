/**
 * Realisation de quelques tests
 */
package com.bootcamp.tests;

import com.bootcamp.AppConstants;
import com.bootcamp.entities.PhaseProgramme;
import com.bootcamp.entities.Programme;
import com.bootcamp.jpa.PhaseProgrammeRepository;
import com.bootcamp.enums.EtatProgramme;
import com.bootcamp.jpa.ProgrammeRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
import org.testng.annotations.Test;

/**
 *
 * @author soul
 */
public class GenerateTableTest  {
//    String pu="databasePU";
    //create a new objet phaseprogramme
        PhaseProgramme nPhase1=new PhaseProgramme();
        //create a new objet phaseprogramme
        PhaseProgramme nPhase2=new PhaseProgramme();
        //create a new objet phaseprogramme
        PhaseProgramme nPhase3=new PhaseProgramme();
        //create a new objet phaseprogramme
        PhaseProgramme nPhase4=new PhaseProgramme();


  @Test
    public void generateTables(){

        Persistence.createEntityManagerFactory(AppConstants.PERSISTENCE_UNIT, new Properties() {});
    }

    @Test
    public void createPhases(){
        //need to extends baserepository for phaseprogram
        PhaseProgrammeRepository donPhase=new PhaseProgrammeRepository(AppConstants.PERSISTENCE_UNIT);

        
        //set its name
        nPhase1.setNomPhase("Phase de sensibilisation");
        
        //set its name
        nPhase2.setNomPhase("Phase de communication");
        
        //set its name
        nPhase3.setNomPhase("Phase de vulgarisation");
        
        //set its name
        nPhase4.setNomPhase("Phase de cohercision");
       try {
        donPhase.create(nPhase1);
        donPhase.create(nPhase2);
        donPhase.create(nPhase3);
        donPhase.create(nPhase4);
            } catch (SQLException ex) {
                Logger.getLogger(GenerateTableTest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Test
    public void createProgrammes(){

     String nom="Luttre contre violence conjugale";

     String description="zero tolerance aux violences faites aux femmes"; //description du programme

     int idObjectif=3; //id to recevoir permettant de faire des recherche sur un objectif precis

     double budprevionnel=100000000;

     double coutreel=300000000;

    Date dateDebutPrev= new Date(2014/01/01);

   Date dateFinPrev=new Date(2014/12/31);

    Date dateDebutReel=new Date(2014/03/01);

    Date dateFinReel=new Date(2015/06/01);

    List<PhaseProgramme> nomPhases=new ArrayList<>();
    //add some phases tu this project
    nomPhases.add(nPhase1);
    nomPhases.add(nPhase2);
    nomPhases.add(nPhase3);
    nomPhases.add(nPhase4);

    //other programs may have other phases

    PhaseProgramme phaseActuelle=nPhase1; // the programme is at begenning

    EtatProgramme etatProgramme=EtatProgramme.PREETUDE;

        Programme nvoProg=new Programme();
        nvoProg.setBudprevionnel(budprevionnel);
        nvoProg.setNom(nom);
        nvoProg.setDescription(description);
        nvoProg.setPhaseActuelle(phaseActuelle);
        nvoProg.setIdObjectif(idObjectif);
        nvoProg.setCoutreel(coutreel);
        nvoProg.setDateDebutPrev(dateDebutPrev);
        nvoProg.setDateDebutReel(dateDebutReel);
        nvoProg.setDateFinPrev(dateFinPrev);
        nvoProg.setDateFinReel(dateFinReel);
        nvoProg.setNomPhases(nomPhases);
        nvoProg.setEtatProgramme(etatProgramme);
        ProgrammeRepository donnees=new ProgrammeRepository(AppConstants.PERSISTENCE_UNIT);
    try {
        donnees.create(nvoProg);
    } catch (SQLException ex) {
        Logger.getLogger(GenerateTableTest.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
}
