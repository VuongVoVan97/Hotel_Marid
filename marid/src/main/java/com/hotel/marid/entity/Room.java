package com.hotel.marid.entity;

import com.hotel.marid.config.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Room")
@Data
public class Room extends BaseEntity {

    private String roomNumber;

    @Column(name = "available")
    private Boolean isAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private RoomType roomType;
}
