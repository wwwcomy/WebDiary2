create database webdiary default character set utf8mb4 collate utf8mb4_unicode_ci;

create table users (
    username varchar(50) not null primary key,
    password varchar(50) not null,
    enabled boolean not null
) engine = InnoDb;

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username),
    unique index authorities_idx_1 (username, authority)
) engine = InnoDb;


insert into users (username,password,enabled) values ('admin','{noop}admin',true);
insert into authorities(username,authority) values ('admin','ADMIN');

create table diary (
	id int UNSIGNED not null primary key AUTO_INCREMENT,
    diary_date datetime not null,
    username varchar(50) not null,
    weather varchar(50) not null,
    title varchar(200) not null,
    memo MEDIUMTEXT,
    created_date datetime not null
) engine = InnoDb;
-- max 16383 for utf8mb4_unicode_ci
-- notice that by default, mysql in MAC does not support Chinese, need to define /etc/my.cnf
-- https://www.jianshu.com/p/e4923a6b1b3b

insert into diary (diary_date, username, weather,title,memo, created_date)
values
('2017-11-05 20:29:36', 'admin','晴天','标题1','这是内容','2017-11-05 20:29:36');