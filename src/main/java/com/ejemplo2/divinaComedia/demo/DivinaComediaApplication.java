package com.ejemplo2.divinaComedia.demo;

import com.ejemplo2.divinaComedia.demo.respositories.crud.HairProductCrudRepository;
import com.ejemplo2.divinaComedia.demo.respositories.crud.OrderCrudRepository;
import com.ejemplo2.divinaComedia.demo.respositories.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.ejemplo2.divinaComedia.demo.model"})
@SpringBootApplication
public class DivinaComediaApplication implements CommandLineRunner {

    @Autowired
    private HairProductCrudRepository productRepository;

    @Autowired
    private UserCrudRepository userRepository;
    
     @Autowired
    private OrderCrudRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(DivinaComediaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.deleteAll();
        userRepository.deleteAll();
        orderRepository.deleteAll();
    }

}
