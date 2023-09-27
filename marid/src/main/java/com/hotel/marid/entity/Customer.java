package com.hotel.marid.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotel.marid.config.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;


import java.util.Set;

@Entity
@Table(name = "customer")
@Data
public class Customer extends BaseEntity {
    private String name;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Booking> bookingSet;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Room> roomSet;

}