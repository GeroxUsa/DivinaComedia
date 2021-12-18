/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo2.divinaComedia.demo.respositories;

import com.ejemplo2.divinaComedia.demo.model.Order;
import com.ejemplo2.divinaComedia.demo.model.User;
import com.ejemplo2.divinaComedia.demo.respositories.crud.OrderCrudRepository;
import com.ejemplo2.divinaComedia.demo.respositories.crud.UserCrudRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author danie
 */
@Repository
public class OrderRepository {
    @Autowired
   private OrderCrudRepository repository;

   public List<Order> getAll(){
       return (List<Order>)repository.findAll();
   }
   
   public Order save(Order order){
       return repository.save(order);
   }
   
   public Optional getOrderById(int id){
       return repository.findById(id);
   }
    
   public void delete(int id){
      repository.deleteById(id);
   }
   
   public Optional<Order> lastUserId(){
        return repository.findTopByOrderByIdDesc();
    }
   
   public List<Order> findByZone(final String zone){
       return (List<Order>)repository.findByZone(zone);
   }
   
   public List<Order> findBySalesManId(final int id){
       return (List<Order>)repository.findBySalesManId(id);
   }
   
   public List<Order> findByRegisterDayAndSalesMan_Id(final Date registerDay, final int id){
       return (List<Order>)repository.findByRegisterDayAndSalesMan_Id(registerDay, id);
   }
   
   public List<Order> findByStatusAndSalesMan_Id(final String status, final int id){
       return (List<Order>)repository.findByStatusAndSalesMan_Id(status, id);
   }
}
