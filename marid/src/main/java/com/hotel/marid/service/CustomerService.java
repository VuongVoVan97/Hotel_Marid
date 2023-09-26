package com.hotel.marid.service;

import com.hotel.marid.entity.Customer;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface CustomerService {

    Boolean create(Customer customer);

    List<Customer> retrieveAll()throws ChangeSetPersister.NotFoundException;
    Customer retrieveById(Long id) throws ChangeSetPersister.NotFoundException;
    Customer retrieveByPhoneNumber(String phoneNumber) throws ChangeSetPersister.NotFoundException;
    List<Customer> retrieveByCustomerContaining(String name) throws ChangeSetPersister.NotFoundException;

    Boolean update(Customer customer);

    Boolean delete(Customer customer);


}
