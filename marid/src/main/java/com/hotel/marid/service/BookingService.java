package com.hotel.marid.service;

import com.hotel.marid.entity.Booking;
import com.hotel.marid.entity.Customer;
import com.hotel.marid.entity.Room;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface BookingService {

   Boolean create(Customer customer, Date dateIn, Date dateOut, Set<Room>roomSet);

   List<Booking> retrieveAll();
    List<Booking> retrieveByCustomer(Customer customer);
    List<Booking> retrieveByCustomer(String phoneNumber);

    Boolean update(Customer customer);

    Boolean delete(Customer customer);

}
