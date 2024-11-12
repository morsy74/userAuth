package com.example.mvcdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.mvcdemo.database.entity.Customer;
import com.example.mvcdemo.database.repository.CustomerRepository;

@Service
public class CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public void addNewCustomer(Customer customer) {
    customerRepository.save(customer);
  }

  public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
  }

  public List<Customer> findCustomersByName(String firstName) {
    return customerRepository.findByNameContainingIgnoreCase(firstName);
}

  public Customer getCustomerById(long id) {
    Optional <Customer> optional = customerRepository.findById(id);
    Customer customer = null;
    if(optional.isPresent()){
      customer = optional.get();
    } else {
      throw new RuntimeException("Customer not found for id :: " + id);
    }
    return customer;
  }
    public void deleteCustomerById(long id) {
        this.customerRepository.deleteById(id);
    }

  
}
