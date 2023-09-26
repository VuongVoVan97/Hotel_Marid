package com.hotel.marid.service;

import com.hotel.marid.entity.RoomType;

import java.util.List;

public interface RoomTypeService {

    Boolean create(RoomType roomType);

    List<RoomType> retrieveAll();
    List<RoomType> retrieveByUnitPriceBelow(double unitPrice);

    Boolean update(RoomType roomType);

    Boolean delete(RoomType roomType);
}
