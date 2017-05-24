

create database core_buddy;


mysql> create database core_buddy;
Query OK, 1 row affected (0.00 sec)

mysql> create user 'prodbuddy'@'localhost' identified by 'uveja3yqu';
Query OK, 0 rows affected (0.09 sec)

mysql> grant all on core_buddy.* to 'prodbuddy'@'localhost';
Query OK, 0 rows affected (0.01 sec)

use core_buddy;


CREATE  TABLE buddy_user (
  user_id int(11) NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(45) NOT NULL ,
  full_name VARCHAR(45) NOT NULL ,
  age int(11) NOT NULL ,
  gender char(1) NOT NULL ,
  user_image_url VARCHAR(4000)  ,
  mobile_number bigint(15) NOT NULL ,
  location_id int(11) ,
  location_name VARCHAR(45) ,
  enable TINYINT  DEFAULT 1 ,
  password VARCHAR(45) NOT NULL ,
  created_by VARCHAR(45)  ,
  created_date DATETIME,
  last_updated_by VARCHAR(45) ,
  last_updated_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ,
  PRIMARY KEY (user_id));
  
  /*postgress*/
  CREATE  TABLE buddy_user (
  user_id SERIAL  PRIMARY KEY,
  user_name varchar(45) NOT NULL ,
  full_name varchar(45) NOT NULL ,
  age integer NOT NULL ,
  gender char(1) NOT NULL ,
  user_image_url varchar(4000)  ,
  mobile_number bigint  NOT NULL ,
  location_id integer ,
  location_name varchar(45) ,
  password varchar(45) NOT NULL ,
  created_by varchar(45)  ,
  created_date timestamp default NULL,
  last_updated_by varchar(45) default NULL ,
  last_updated_date timestamp  default NULL );
