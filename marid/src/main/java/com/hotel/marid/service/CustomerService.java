package com.hotel.marid.service;

import com.hotel.marid.entity.Customer;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface CustomerService {

    List<Customer> retrieveAll();

    Customer retrieveById(long id) throws ChangeSetPersister.NotFoundException;

    Customer create(Customer customer);

    Customer update(Customer customer);

    void delete(long id);


}
