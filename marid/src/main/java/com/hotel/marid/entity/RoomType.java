package com.hotel.marid.entity;

import com.hotel.marid.config.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Table(name = "room_type")
@Data
public class RoomType extends BaseEntity {
    private String name;
    private double unitPrice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Room> roomSet;
}