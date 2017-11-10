/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.tests;

import com.bootcamp.AppConstants;
import com.bootcamp.entities.Beneficiaire;
import com.bootcamp.jpa.BeneficiaireRepository;
import java.sql.SQLException;
import org.testng.annotations.Test;
/**
 *
 * @author Archange
 */
public class BeneficiaireTest {
    private final BeneficiaireRepository beneficiaireRepository = new BeneficiaireRepository(AppConstants.PERSISTENCE_UNIT);
//    @Test
//    public void generateTables() {
////        Persistence.("tpJpa", new Properties());
//        Persistence.createEntityManagerFactory(persistOne, new Properties() {
//        });
//
//    }

   	@Test
	public void createBeneficiaire() throws SQLException {
		Beneficiaire b = new Beneficiaire("TOTO", "MOMO");
                Beneficiaire b1 = new Beneficiaire("ALOUNKOUN", "Emile");
                Beneficiaire b2 = new Beneficiaire("GANDONOU", "Archange");
                Beneficiaire b3 = new Beneficiaire("ASSA", "Azaria");
                beneficiaireRepository.create(b);
                 beneficiaireRepository.create(b1);
                  beneficiaireRepository.create(b2);
                   beneficiaireRepository.create(b);
	}
    
    
}
