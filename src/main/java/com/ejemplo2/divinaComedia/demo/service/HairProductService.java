/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo2.divinaComedia.demo.service;

import com.ejemplo2.divinaComedia.demo.model.HairProduct;
import com.ejemplo2.divinaComedia.demo.respositories.HairProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */
@Service
public class HairProductService {

    @Autowired
    private HairProductRepository repository;

    public List<HairProduct> getAll() {
        return repository.getAll();
    }

    public HairProduct save(HairProduct product) {
        if (product.getReference() == null) {
            return repository.save(product);
        } else {
            Optional<HairProduct> existProduct = repository.exitProduct(product.getReference());
            if (!existProduct.isPresent()) {
                return repository.save(product);
                
            } else {
                return product;
            }
        }

    }

    public HairProduct update(HairProduct user) {
        if(repository.exitProduct(user.getReference()).isPresent()){
            return repository.save(user);
        }
        else{
            return user;
        }
    }

    public void delete(String reference) {

        if(repository.exitProduct(reference).isPresent()){
            repository.delete(reference);
        }
        
    }

}
