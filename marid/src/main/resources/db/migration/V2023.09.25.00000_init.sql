DROP TABLE IF EXISTS ROOM;

CREATE TABLE ROOM (
  id BIGINT PRIMARY KEY AUTO_INCREMENT
  , room_number VARCHAR(255)
    available BIT(1),
    PRIMARY KEY (id)
);