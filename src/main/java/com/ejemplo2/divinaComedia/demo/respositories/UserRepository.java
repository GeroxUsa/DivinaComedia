
package com.ejemplo2.divinaComedia.demo.respositories;

import com.ejemplo2.divinaComedia.demo.model.User;
import com.ejemplo2.divinaComedia.demo.respositories.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danie
 */
@Repository
public class UserRepository {
    
   @Autowired
   private UserCrudRepository repository;

   public List<User> getAll(){
       return (List<User>)repository.findAll();
   }
   
   public User save(User user){
       return repository.save(user);
   }
   
   public Optional getUserById(int id){
       return repository.findById(id);
   }
   
   public Optional<User> getUserByName(String name){
       return repository.findByName(name);
   }
   
   public Optional<User> getUserByEmail(String email){
       return repository.findByEmail(email);
   }
   
   public List<User> getUserByNameOrEmAIL(String name, String email){
       return repository.findByNameOrEmail(name, email);
   }
   
   public Optional<User> getUserByEmailAndPassword(String email, String password){
       return repository.findByEmailAndPassword(email, password);
   }
   
}
