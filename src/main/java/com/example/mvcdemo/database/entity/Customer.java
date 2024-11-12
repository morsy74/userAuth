package com.example.mvcdemo.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Customers")
public class Customer {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable= false)
  private Long id;

  @Column(name = "Customer-Name", nullable= false)
  private String name;

  @Column(name = "Customer-Email", nullable= false, unique=true)
  private String email;

  @Column(name = "Customer-Phone", nullable= false)
  private String phone;
}
