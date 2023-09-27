package com.hotel.marid.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hotel.marid.config.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "booking")
@Data
public class Booking extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateIn;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "id")
    @JsonIgnore
    private Set<Room> roomSet;



}