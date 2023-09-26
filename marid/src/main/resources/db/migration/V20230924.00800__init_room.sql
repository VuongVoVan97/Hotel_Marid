USE marid_hotel;
DROP TABLE IF EXISTS room;


CREATE TABLE ROOM (
  id BIGINT PRIMARY KEY AUTO_INCREMENT
  , room_number VARCHAR(255) NOT NULL
  , available BIT(1) NOT NULL
  , customer_id BIGINT
  , booking_id BIGINT
  , room_type_id BIGINT
  ,  FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id)
  ,  FOREIGN KEY (booking_id) REFERENCES BOOKING(id)
  ,  FOREIGN KEY (room_type_id) REFERENCES ROOM_TYPE(id)
);