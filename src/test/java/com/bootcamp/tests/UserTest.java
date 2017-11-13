/**
 *
 * @Bignon
 */
package com.bootcamp.tests;

import com.bootcamp.AppConstants;
import com.bootcamp.entities.User;
import com.bootcamp.jpa.UserRepository;
import java.sql.SQLException;
import java.util.List;
import org.testng.annotations.Test;

public class UserTest {
    UserRepository pr = new UserRepository(AppConstants.PERSISTENCE_UNIT);
    
    @Test
    public void create() throws SQLException{
     User user = new User();
     user.setLogin("user000");
     user.setPwd("pass000");     
     pr.create(user);
     
     user.setLogin("user001");
     user.setPwd("pass001");
     pr.create(user);
     
     user.setLogin("user002");
     user.setPwd("pass002");
     pr.create(user);
    }
    
     public void update() throws SQLException{
     User user = pr.findByPropertyUnique("id", 3);
     user.setLogin("user003modifie");
     pr.update(user);
    }
     
    public void delete() throws SQLException{
     User user = pr.findByPropertyUnique("id", 2);
     pr.delete(user);
    }
    
     public void findall() throws SQLException{
     List<User> users = pr.findAll();
    }
}
