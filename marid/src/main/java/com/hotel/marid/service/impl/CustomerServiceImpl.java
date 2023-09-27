package com.hotel.marid.service.impl;

import com.hotel.marid.entity.Customer;
import com.hotel.marid.repository.CustomerRepository;
import com.hotel.marid.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> retrieveAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer retrieveById(long id) throws ChangeSetPersister.NotFoundException {
        return customerRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(long id) {
        customerRepository.deleteById(id);
    }
}
