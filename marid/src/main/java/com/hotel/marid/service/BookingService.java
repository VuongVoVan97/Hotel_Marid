package com.hotel.marid.service;

import com.hotel.marid.entity.Booking;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface BookingService {

    List<Booking> retrieveAll();

    Booking retrieveById(long id)throws ChangeSetPersister.NotFoundException;

    Booking create(Booking booking);

    Booking update(Booking booking);

    void delete(long id);

}
