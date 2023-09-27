package com.hotel.marid.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotel.marid.config.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Table(name = "room_type")
@Data
public class RoomType extends BaseEntity {
    private String name;

    @Column(name = "unit_price")
    private double unitPrice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roomType", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Room> roomSet;
}