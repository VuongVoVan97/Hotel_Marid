package com.hotel.marid.service.impl;

import com.hotel.marid.entity.RoomType;
import com.hotel.marid.repository.RoomTypeRepository;
import com.hotel.marid.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;

    @Override
    public List<RoomType> retrieveAll() {
        return roomTypeRepository.findAll();
    }

    @Override
    public RoomType retrieveById(long id) throws ChangeSetPersister.NotFoundException {
        return roomTypeRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public RoomType create(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType update(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public void delete(long id) {
        roomTypeRepository.deleteById(id);
    }
}
