package com.bootcamp.tests;

import com.bootcamp.AppConstants;
import com.bootcamp.entities.Bailleur;
import com.bootcamp.jpa.BailleurRepository;
import org.testng.annotations.Test;

import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class TestBailleur {
	private BailleurRepository bailleurRepository = new BailleurRepository(AppConstants.PERSISTENCE_UNIT);

	@Test
    public void generateTables(){

        Persistence.createEntityManagerFactory(AppConstants.PERSISTENCE_UNIT, new Properties() {});
    }
	
	@Test
	public void createBailleurs() {
		Bailleur bailleur;
		List<Bailleur> bailleurs= new ArrayList<Bailleur>();
		String noms[]= {"abladon","Moudjib","gerauld","faroud","mariam","barriath",
				"bachiroudine","fatai","mansour"};
		String[] pays= {"Algerie","Afganistan","Allmangne","Belgique","Benin","Burkina-Faso",
				"Canada","Malie","France","Londre","Togo","Ghana","Niger","Nigeria"};
		for(String name:noms) {
			bailleur=new Bailleur();
			System.out.println("bailleur "+name);
			Random rand = new Random();
			int  n = rand.nextInt(pays.length-1) + 1;
			bailleur.setNom(name);
			//System.out.println("bailleur name "+bailleur.getNom());
			bailleur.setPays(pays[n]);
			try {
				bailleurRepository.create(bailleur);
				System.out.println("bailleur name after insertion "+bailleur.getNom());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
