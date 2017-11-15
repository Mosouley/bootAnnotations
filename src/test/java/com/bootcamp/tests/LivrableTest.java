/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.tests;

import static com.bootcamp.AppConstants.PERSISTENCE_UNIT;
import com.bootcamp.entities.Livrable;
import com.bootcamp.enums.EtatLivrable;
import com.bootcamp.jpa.LivrableRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.testng.annotations.Test;

/**
 *
 * @author leger
 */
public class LivrableTest {
    
    private LivrableRepository lr=new LivrableRepository(PERSISTENCE_UNIT);
	
	@Test
	public void ajoutLivrable(){
		List<Object> lieux=new ArrayList<Object>(2);
		lieux.add("cotonou");
		lieux.add("parakou");
		List<Object> objectifs=new ArrayList<Object>(2);
		objectifs.add("obj1");
		objectifs.add("obj2");
		for(int i=0;i<20; i++){
			EtatLivrable et=(i%2==0) ? EtatLivrable.realisation:EtatLivrable.livre;
			int j=i+1;
			Livrable li=new Livrable(j, "ref"+ j, "description"+ j, objectifs, lieux, et, new Random().nextInt(40)+j, new Random().nextInt(40)+j);
			try {
				lr.create(li);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
                }
    
}
