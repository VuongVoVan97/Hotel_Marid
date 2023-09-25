package com.hotel.marid.service.impl;

import com.hotel.marid.entity.Room;
import com.hotel.marid.repository.RoomRepository;
import com.hotel.marid.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Room findById(Long id) throws ChangeSetPersister.NotFoundException {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return room;
    }
}
