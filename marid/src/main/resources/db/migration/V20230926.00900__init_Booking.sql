USE marid_hotel;
DROP TABLE IF EXISTS booking;


CREATE TABLE BOOKING (
  id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL
  , date_in DATETIME NOT NULL
  , date_out DATETIME NOT NULL
  , customer_id BIGINT
--  ,  FOREIGN KEY (customer_id) REFERENCES CUSTOMER(id)
)ENGINE = INNODB;