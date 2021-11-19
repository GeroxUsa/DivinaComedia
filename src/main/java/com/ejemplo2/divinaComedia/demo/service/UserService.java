
package com.ejemplo2.divinaComedia.demo.service;

import com.ejemplo2.divinaComedia.demo.model.User;
import com.ejemplo2.divinaComedia.demo.respositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> getAll(){
        return repository.getAll();
    }
    
    public User save(User user){
        if(user.getId()==null){
            List<User> exisUsers = repository.getUserByNameOrEmAIL(user.getName(), user.getEmail());
            if(exisUsers.isEmpty()){
                return repository.save(user);
            }
            return repository.save(user);
        }else{
           Optional<User> existUser = repository.getUserById(user.getId());
           if(existUser.isPresent()){
               return repository.save(user);
               
           }else{
               return user;
           }
        }
        
    }
    
}
