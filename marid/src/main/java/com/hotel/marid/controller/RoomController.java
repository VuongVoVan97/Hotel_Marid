package com.hotel.marid.controller;

import com.hotel.marid.entity.Room;
import com.hotel.marid.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("{id}")
    public ResponseEntity<Room> findById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Room room = roomService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(room);
    }
}
