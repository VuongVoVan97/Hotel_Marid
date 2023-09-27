package com.hotel.marid.service.impl;

import com.hotel.marid.entity.Booking;
import com.hotel.marid.repository.BookingRepository;
import com.hotel.marid.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public List<Booking> retrieveAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking retrieveById(long id) throws ChangeSetPersister.NotFoundException {
        return bookingRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    @Transactional
    public Booking create(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    @Transactional
    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    @Transactional
    public void delete(long id) {
        bookingRepository.deleteById(id);
    }
}
