package com.hotel.marid.controller;

import com.hotel.marid.entity.Room;
import com.hotel.marid.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("")
    public List<Room> retrieveAll() {
        return roomService.retrieveAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> retrieveById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        Room room = roomService.retrieveById(id);
        return ResponseEntity.status(HttpStatus.OK).body(room);
    }

    @PostMapping("")
    public ResponseEntity<Room> createRoom(@RequestBody Room room) {
        Room newRoom = roomService.create(room);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id,@RequestBody Room room) throws ChangeSetPersister.NotFoundException {
        Room updateRoom=roomService.retrieveById(id);
        room.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(room);
    }

    @DeleteMapping("/{id}")
    public List<Room> deleteRoom(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        Room deleteRoom=roomService.retrieveById(id);
        roomService.delete(id);
        return roomService.retrieveAll();
    }

}
