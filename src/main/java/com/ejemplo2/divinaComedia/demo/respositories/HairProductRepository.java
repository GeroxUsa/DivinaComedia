/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo2.divinaComedia.demo.respositories;

import com.ejemplo2.divinaComedia.demo.model.HairProduct;
import com.ejemplo2.divinaComedia.demo.respositories.crud.HairProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danie
 */
@Repository
public class HairProductRepository {
    
    @Autowired
    private  HairProductCrudRepository repository;
    
    public List<HairProduct> getAll(){
        return (List<HairProduct>)repository.findAll();
    }
    
    public HairProduct save(HairProduct product){
        return repository.save(product);
    }
    
    public void delete(String reference){
        repository.deleteById(reference);
    }
    
    public Optional<HairProduct> exitProduct(String reference){
        return repository.findById(reference);
    }
    
    
}
