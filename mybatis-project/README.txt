
create database mybatis;

use mybatis;

create table students(
    id int primary key,
    name varchar(10),
    salary double
);


insert into students values(1,'liguodong',1000.00);


StudentsMapper.xml --> 映射实体与表结构

mybatis_config.xml --> mybatis配置信息









