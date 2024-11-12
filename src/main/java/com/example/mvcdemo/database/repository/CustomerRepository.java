package com.example.mvcdemo.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mvcdemo.database.entity.Customer;

@Repository
public interface  CustomerRepository extends JpaRepository<Customer, Long>{
  List<Customer> findByNameContainingIgnoreCase(String firstName);
}
