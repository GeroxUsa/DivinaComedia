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

    public List<User> getAll() {
        return repository.getAll();
    }
    
    public Optional getUserById(int id) {
        return repository.getUserById(id);
    }

    public User save(User user) {
        if (user.getId() == null) {
//            List<User> exisUsers = repository.getUserByNameOrEmAIL(user.getName(), user.getEmail());
//            if(exisUsers.isEmpty()){
//                return repository.save(user);
//            }
            return user;
        } else {

            Optional<User> existUser = repository.getUserById(user.getId());
            if (!existUser.isPresent()) {
                if (user.getIdentification() == null || user.getEmail() == null || user.getName() == null || user.getPassword() == null || user.getType() == null) {
                    return user;
                } else {
                    List<User> existsUsers = repository.getUserByIdOrEmailOrName(user.getId(), user.getEmail(), user.getName());
                    if (existsUsers.isEmpty()) {
                        return repository.save(user);
                    } else {
                        return user;
                    }

                }

            } else {
                return user;
            }

        }

    }

    public User update(User user) {
        Optional<User> existUser = repository.getUserById(user.getId());
       
        if(existUser.isPresent()){
            return repository.save(user);
        }else{
            return user;
        }
        
        

    }

    public boolean delete(int id) {
        Optional<User> existUser = repository.getUserById(id);
       
        if(existUser.isPresent()){
            repository.delete(id);
            return true;
        }
        return false;
    }

    public boolean getUserByEmail(String email) {
        return repository.getUserByEmail(email).isPresent();
    }

    public User getUserByEmailAndPasword(String email, String password) {

        Optional<User> user = repository.getUserByEmailAndPassword(email, password);

        if (user.isPresent()) {
            return user.get();
        } else {
            return new User(null, null, null, null, null, null, null, null, null, null, null);
        }
    }

}
