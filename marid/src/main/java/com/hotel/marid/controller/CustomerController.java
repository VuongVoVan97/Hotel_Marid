package com.hotel.marid.controller;

import com.hotel.marid.entity.Customer;
import com.hotel.marid.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public List<Customer> retrieveAll() {
        return customerService.retrieveAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> retrieveById(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        Customer customer = customerService.retrieveById(id);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @PostMapping("")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.create(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomer);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer) throws ChangeSetPersister.NotFoundException {
        Customer updateCustomer = customerService.retrieveById(id);
        customer.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(customer);
    }

    @DeleteMapping("/{id}")
    public List<Customer> deleteCustomer(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        Customer deleteCustomer = customerService.retrieveById(id);
        customerService.delete(id);
        return customerService.retrieveAll();
    }
}
