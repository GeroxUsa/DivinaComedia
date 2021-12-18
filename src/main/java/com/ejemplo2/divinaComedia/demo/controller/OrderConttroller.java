/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo2.divinaComedia.demo.controller;

import com.ejemplo2.divinaComedia.demo.model.Order;
import com.ejemplo2.divinaComedia.demo.service.OrderService;

import java.util.List;
import java.util.Optional;
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
@RequestMapping("order")
@CrossOrigin(origins = "*")
public class OrderConttroller {
    
    @Autowired
    private OrderService service;
    
    @GetMapping("/all")
    public List<Order> getOrders(){
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional GetOrderById(@PathVariable("id") Integer id){
      return service.getOrderById(id);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){       
        return service.save(order);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){       
        return service.update(order);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
      return service.delete(id);
    }
    
    @GetMapping("/zona/{zone}")
    public List<Order> GetOrderByZona(@PathVariable("zone") String zona){
      return service.getOrdersByZone(zona);
    }
    
    @GetMapping("/salesman/{id}")
    public List<Order> GetOrderByZona(@PathVariable("id") int id){
      return service.findBySalesManId(id);
    }
    
    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> findByRegisterDayAndSalesMan_Id(@PathVariable("registerDay") String registerDay, @PathVariable("id") int id){
       return service.findByRegisterDayAndSalesMan_Id(registerDay, id);
   }
   @GetMapping("/state/{status}/{id}")
   public List<Order> findByStatusAndSalesMan_Id(@PathVariable("status") String status, @PathVariable("id") int id){
       return service.findByStatusAndSalesMan_Id(status, id);
   }
    
    
}
