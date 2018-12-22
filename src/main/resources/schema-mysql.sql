
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS employee;

create table employee (
    eid Integer(10) NOT NULL AUTO_INCREMENT primary key ,
    ename varchar(50) not null unique ,
    emailid varchar(120) not null,
    emobile varchar(20) not null
);

create table users (
    id VARCHAR(10) NOT NULL AUTO_INCREMENT primary key ,
    username varchar(50) not null unique ,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null unique,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);
 insert into employee(eid, ename, emailid, emobile)values(1001,'Rahul','rahul@gmail.com','123456789');
 insert into employee(eid, ename, emailid, emobile)values(1002,'Kinshuk','kinshuk@gmail.com','123456799');
 
 insert into users(id, username, password, enabled)values('1001','ram123','ram123',true);
 insert into authorities(username, authority)values('ram123','ROLE_ADMIN');
 
 insert into users(id, username, password, enabled)values('1002','ravi','ravi',true);
 insert into authorities(username, authority)values('ravi','ROLE_USER');
 
