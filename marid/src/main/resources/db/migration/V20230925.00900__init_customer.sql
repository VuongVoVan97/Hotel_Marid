USE marid_hotel;
DROP TABLE IF EXISTS room;


CREATE TABLE ROOM (
  id BIGINT PRIMARY KEY AUTO_INCREMENT
  , room_number VARCHAR(255),
    available BIT(1)
);