/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemplo2.divinaComedia.demo.model;

import java.util.Date;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author danie
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="orders")
public class Order {

    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;

    private Map<String, HairProduct> products;
    private Map<String, Integer> quantities;

}

