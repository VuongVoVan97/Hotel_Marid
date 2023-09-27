package com.hotel.marid.service;

import com.hotel.marid.entity.Room;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface RoomService {

    List<Room> retrieveAll();

    Room retrieveById(long id) throws ChangeSetPersister.NotFoundException;

    Room create(Room room);

    Room update(Room room);

    void delete(long id);
}
