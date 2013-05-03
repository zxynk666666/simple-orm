drop database orm if exists orm;
create database orm;
use orm;

create table pets(
  id INT,
  name VARCHAR(100),
  gender VARCHAR(10),
  age INT
);