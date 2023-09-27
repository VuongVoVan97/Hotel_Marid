package com.hotel.marid.controller;

import com.hotel.marid.entity.RoomType;
import com.hotel.marid.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("room-type")
public class RoomTypeController {
    @Autowired
    private RoomTypeService roomTypeService;

    @GetMapping("")
    public List<RoomType> retrieveAll() {
        return roomTypeService.retrieveAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomType> retrieveById(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        RoomType roomType = roomTypeService.retrieveById(id);
        return ResponseEntity.status(HttpStatus.OK).body(roomType);
    }

    @PostMapping("")
    public ResponseEntity<RoomType> createRoomType(@RequestBody RoomType roomType) {
        RoomType newRoomType = roomTypeService.create(roomType);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRoomType);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoomType> updateRoomType(@PathVariable long id, @RequestBody RoomType roomType) throws ChangeSetPersister.NotFoundException {
        RoomType updateRoomType = roomTypeService.retrieveById(id);
        roomType.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(roomType);
    }

    @DeleteMapping("/{id}")
    public List<RoomType> deleteRoomType(@PathVariable long id) throws ChangeSetPersister.NotFoundException {
        RoomType deleteRoomType = roomTypeService.retrieveById(id);
        roomTypeService.delete(id);
        return roomTypeService.retrieveAll();
    }
}
