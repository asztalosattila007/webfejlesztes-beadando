package com.example.beadando.Service.impl;

import com.example.beadando.Entity.CustomerEntity;
import com.example.beadando.Repository.CustomerRepository;
import com.example.beadando.Service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerEntity getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public CustomerEntity updateCustomer(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }


}
