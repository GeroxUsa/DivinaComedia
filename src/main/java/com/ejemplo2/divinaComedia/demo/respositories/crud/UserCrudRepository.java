/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo2.divinaComedia.demo.respositories.crud;

import com.ejemplo2.divinaComedia.demo.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author danie
 */
public interface UserCrudRepository extends MongoRepository<User, Integer>{
    
    public Optional<User> findByName(String name);

    public Optional<User> findByEmail(String email);
    
    public List<User> findByNameOrEmail(String name, String email);
    
    public Optional<User> findByEmailAndPassword(String email, String password);
    
    @Query("{ id : ?0 }")
    public Optional<User> findUserByid(int id);
    
    public List<User> findByIdOrEmailOrName(Integer id, String email, String name);

}
