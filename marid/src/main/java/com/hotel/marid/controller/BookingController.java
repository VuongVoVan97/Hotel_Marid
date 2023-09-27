package com.hotel.marid.controller;

import com.hotel.marid.entity.Booking;
import com.hotel.marid.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("")
    public List<Booking> retrieveAll() {
        return bookingService.retrieveAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> retrieveById(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        Booking booking = bookingService.retrieveById(id);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    @PostMapping("")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking newBooking = bookingService.create(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBooking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable long id, @RequestBody Booking booking) throws ChangeSetPersister.NotFoundException {
        Booking updateBooking = bookingService.retrieveById(id);
        booking.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(booking);
    }

    @DeleteMapping("/{id}")
    public List<Booking> deleteBooking(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        Booking deleteBooking = bookingService.retrieveById(id);
        bookingService.delete(id);
        return bookingService.retrieveAll();
    }
}
