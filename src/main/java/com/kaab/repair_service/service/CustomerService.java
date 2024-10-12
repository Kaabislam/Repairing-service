package com.kaab.repair_service.service;

import com.kaab.repair_service.model.Customer;
import com.kaab.repair_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

//    public Customer updateCustomer(Long id, Customer customer) {
//        // Logic to update customer
//    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
