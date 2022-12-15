package com.example.beadando;

import com.example.beadando.Entity.CustomerEntity;
import com.example.beadando.Entity.ProductEntity;
import com.example.beadando.Repository.CustomerRepository;
import com.example.beadando.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class BeadandoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BeadandoApplication.class, args);
    }

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        /*ProductEntity product1 = new ProductEntity("Futball-labda 2022 QATAR AL RIHLA","Adidas","Sport",9990);
        productRepository.save(product1);

        ProductEntity product2 = new ProductEntity("LEGO Icons - Karácsonyi főutca","LEGO","Gyerek",39995);
        productRepository.save(product2);

        ProductEntity product3 = new ProductEntity("Microsoft Xbox SERIES X Játékkonzol","Microsoft","Elektronika",224990 );
        productRepository.save(product3);

        ProductEntity product4 = new ProductEntity("Apple iPhone 11 Mobiltelefon","Apple","Elektronika",224990 );
        productRepository.save(product4);*/

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1= simpleDateFormat.parse("2018-09-09");

       /* CustomerEntity customer1= new CustomerEntity("Kiss","Ferenc","kissferi@gamemail.com",date1);
        customerRepository.save(customer1);

        CustomerEntity customer2= new CustomerEntity("Nagy","Tihamér","nincsegyhuszasod@gmail.com", simpleDateFormat.parse("1999-01-01"));
        customerRepository.save(customer2);*/


    }
}
