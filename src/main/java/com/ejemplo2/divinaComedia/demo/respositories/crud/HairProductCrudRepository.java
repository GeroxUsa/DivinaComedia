package com.ejemplo2.divinaComedia.demo.respositories.crud;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.ejemplo2.divinaComedia.demo.model.HairProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author danie
 */
public interface HairProductCrudRepository extends MongoRepository<HairProduct, String>{
    
    

}
