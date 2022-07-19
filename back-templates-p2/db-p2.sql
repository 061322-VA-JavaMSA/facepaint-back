drop table if exists users;
create table if not exists users(
id serial primary key,
username varchar(30) unique,
password varchar(30),
first_name varchar(30),
last_name varchar(30),
role_id int references user_role(id),
showcase_art int references art(id)
);
drop table if exists user_role
create table if not exists user_role(
id serial primary key,
user_role varchar(30) default basic_user
);

drop table if exists art
create table if not exists art(
id serial primary key,
art_name varchar(30),
art_year int,
artist varchar(50),
showcase int references users(id)
);


