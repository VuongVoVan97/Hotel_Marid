package com.hotel.marid.entity;

import com.hotel.marid.config.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "Room")
@Data
public class Room extends BaseEntity {
    @Column(name = "room_number")
    private String roomNumber;

    @Column(name = "available")
    private Boolean isAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomType roomType;
}
