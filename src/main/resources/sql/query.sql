
drop database if exists kade;

create database if not exists kade;

use kade;

create table customer(
    id varchar(15) primary key,
    name varchar(50) not null,
    address text not null,
    salary double not null
);
CREATE TABLE item(
    code VARCHAR(15)PRIMARY KEY,
    description TEXT NOT NULL,
    unit_price DOUBLE NOT NULL,
    qty_on_hand INT NOT NULL
);

