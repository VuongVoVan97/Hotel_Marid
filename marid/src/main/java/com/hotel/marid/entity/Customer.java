package com.hotel.marid.entity;

import com.hotel.marid.config.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;



import java.util.Set;

@Entity
@Table(name = "customer")
@Data
public class Customer extends BaseEntity {
    private String name;

    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Booking> bookingSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade = CascadeType.ALL)
    private Set<Room> roomSet;

}