DROP DATABASE if exists ojt;
CREATE DATABASE ojt;
USE ojt;

CREATE TABLE OjtReflection (
id int(5) NOT NULL,
studentId int(5) NOT NULL, 
studentName varchar(20) NOT NULL, 
reflection varchar(140) NOT NULL ,
createdDateTime varchar(20)  DEFAULT current_timestamp() COMMENT 'When record was created. yyyy-MM-dd hh:mm'
);


ALTER TABLE OjtReflection
  ADD PRIMARY KEY (id);

ALTER TABLE OjtReflection
  MODIFY id int(5) NOT NULL AUTO_INCREMENT;
  COMMIT;