package com.hotel.marid.entity;

import com.hotel.marid.config.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Room")
@Data
public class Room extends BaseEntity {

    private String roomNumber;

    private Boolean available;
}
