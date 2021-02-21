create database if not exists fabric;

use fabric;

drop table if exists fabric;

create table fabric (
	id int(10) not null auto_increment,
	fabric_type varchar(50) not null,
	fiber_content varchar(50) not null,
	yardage float(5,2) not null,
	color varchar(20),
	primary key(id)
);