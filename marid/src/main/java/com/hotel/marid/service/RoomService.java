package com.hotel.marid.service;

import com.hotel.marid.entity.Room;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface RoomService {

    Room findById(Long id) throws ChangeSetPersister.NotFoundException;
}
