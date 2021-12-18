/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo2.divinaComedia.demo.controller;

import com.ejemplo2.divinaComedia.demo.model.HairProduct;
import com.ejemplo2.divinaComedia.demo.service.HairProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author danie
 */

@RestController
@RequestMapping("hairproducts")
@CrossOrigin(origins = "*")
public class HairProductController {
    
    @Autowired
    private HairProductService service;
    
    @GetMapping("/all")
    public List<HairProduct> getAll(){
        return service.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct save(@RequestBody HairProduct product){       
        return this.service.save(product);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public HairProduct update(@RequestBody HairProduct product){       
        return this.service.update(product);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id){
       service.delete(id);
    }
    
    
    
    
}
