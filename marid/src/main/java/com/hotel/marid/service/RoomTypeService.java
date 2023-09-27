package com.hotel.marid.service;

import com.hotel.marid.entity.RoomType;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface RoomTypeService {


    List<RoomType> retrieveAll();

    RoomType retrieveById(long id) throws ChangeSetPersister.NotFoundException;

    RoomType create(RoomType roomType);

    RoomType update(RoomType roomType);

    void delete(long id);
}
