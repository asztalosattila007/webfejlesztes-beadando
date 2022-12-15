package com.example.beadando.Service;

import com.example.beadando.Entity.CustomerEntity;
import com.example.beadando.Entity.ProductEntity;

import java.util.List;

public interface CustomerService {

    List<CustomerEntity> getAllCustomers();

   CustomerEntity saveCustomer(CustomerEntity customer);

   CustomerEntity getCustomerById(Long id);

   CustomerEntity updateCustomer(CustomerEntity customer);
   void deleteCustomerById(Long id);
}
