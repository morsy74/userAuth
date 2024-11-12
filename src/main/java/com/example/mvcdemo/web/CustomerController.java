package com.example.mvcdemo.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvcdemo.database.entity.Customer;
import com.example.mvcdemo.service.CustomerService;

@Controller
public class CustomerController {
  
  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }
  @GetMapping("/customer-list")
  public String getAllCustomersPage(Model model) {
    List<Customer> customers = customerService.getAllCustomers();
    model.addAttribute("customers", customers);
    return "customer/customer-list";
  }

  @GetMapping("/add-customer")
  public String getAddCustomerPage(Model model) {
    Customer customer = new Customer();
    model.addAttribute("customer", customer);
    return "customer/add-customer";
  }

  @PostMapping("/add-customer")
  public String addNewCustomer(@ModelAttribute("customer") Customer customer) {
    customerService.addNewCustomer(customer);
    return "redirect:/customer-list";
  }

  @GetMapping("/search")
  public String getSearchResult(@RequestParam("first-name") String name, Model model ) {
    List<Customer> customers = customerService.findCustomersByName(name);
    model.addAttribute("customers", customers);
    return "customer/search-result";
  }

  @GetMapping("/update-customer/{id}")
  public String updateCustomer(@PathVariable(value = "id") long id, Model model) {
    Customer customer = customerService.getCustomerById(id);
    model.addAttribute("customer", customer);
    return "customer/update-customer";
  }

  @GetMapping("/delete-customer/{id}")
  public String deleteCustomer(@PathVariable(value = "id") long id) {
    this.customerService.deleteCustomerById(id);
    return "redirect:/customer-list";
  }

}
