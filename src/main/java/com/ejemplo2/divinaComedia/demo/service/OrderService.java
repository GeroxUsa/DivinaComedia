/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo2.divinaComedia.demo.service;

import com.ejemplo2.divinaComedia.demo.model.Order;
import com.ejemplo2.divinaComedia.demo.respositories.OrderRepository;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author danie
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> getAll() {
        return repository.getAll();
    }

    public Optional getOrderById(int id) {
        return repository.getOrderById(id);
    }

    public Order save(Order order) {
        if (order.getId() == null) {
            return order;
        } else {

            return repository.save(order);

        }

    }

    public Order update(Order order) {
        Optional<Order> existOrder = repository.getOrderById(order.getId());

        if (existOrder.isPresent()) {
            return repository.save(order);
        } else {
            return order;
        }

    }

    public boolean delete(int id) {
        Optional<Order> existOrder = repository.getOrderById(id);

        if (existOrder.isPresent()) {
            repository.delete(id);
            return true;
        }
        return false;
    }
    
    public List<Order> getOrdersByZone(final String zone) {
        return repository.findByZone(zone);
    }
    
    public List<Order> findBySalesManId(final int id) {
        return repository.findBySalesManId(id);
    }
    
    public List<Order> findByRegisterDayAndSalesMan_Id(final String registerDay, final int id){
        int year = Integer.parseInt(registerDay.substring(0,4));
        int month = Integer.parseInt(registerDay.substring(5,7));
        int day = Integer.parseInt(registerDay.substring(8,10));

        Calendar fecha = new GregorianCalendar(year, month-1, day, 5, 0);
        return repository.findByRegisterDayAndSalesMan_Id(fecha.getTime(), id);
   }


   
   public List<Order> findByStatusAndSalesMan_Id(final String status, final int id){
       return (List<Order>)repository.findByStatusAndSalesMan_Id(status, id);
   }

 
}
