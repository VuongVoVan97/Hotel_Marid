package com.hotel.marid.service.impl;

import com.hotel.marid.entity.Room;
import com.hotel.marid.repository.RoomRepository;
import com.hotel.marid.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> retrieveAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room retrieveById(long id) throws ChangeSetPersister.NotFoundException {
        return roomRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    @Transactional
    public Room create(Room room) {
        return roomRepository.save(room);

    }

    @Override
    @Transactional
    public Room update(Room room) {
        return roomRepository.save(room);
    }

    @Override
    @Transactional
    public void delete(long id) {
        roomRepository.deleteById(id);
    }
}
