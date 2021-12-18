/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo2.divinaComedia.demo.respositories.crud;

import com.ejemplo2.divinaComedia.demo.model.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author danie
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    //Retorna las ordenes de pedido que coincidad con la zona recibida como parametro
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);
    
    @Query("{'salesMan.id': ?0}")
    List<Order> findBySalesManId(final Integer id);
    
    List<Order> findByRegisterDayAndSalesMan_Id(final Date registerDay, final Integer id);

    List<Order> findByStatusAndSalesMan_Id(final String status, final Integer id);
    
    //Para seleccionar la orden con el id maximo
    Optional<Order> findTopByOrderByIdDesc();
}
