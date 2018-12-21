
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;


create table users (
    Id VARCHAR(10) NOT NULL primary key ,
    username varchar(50) not null unique ,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

 insert into users(Id, username, password, enabled)values('1001','ram123','ram123',true);
 insert into authorities(username,authority)values('ram123','ROLE_ADMIN');
 
  insert into users(Id, username, password, enabled)values('1002','ravi','ravi',true);
 insert into authorities(username,authority)values('ravi','ROLE_USER');