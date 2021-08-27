#users table
create table users(
    username varchar(50) not null primary key,
    password varchar(500) not null,
    enabled boolean not null
);

#authorities table
create table authorities(
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);


#insert data
insert into users (username, password, enabled) values ('alice', '{noop}alicepw', 1);
insert into users (username, password, enabled) values ('bob', '{noop}bobpw', 0);

insert into users (username, authority) values ('alice', 'ROLE_ADMIN');
insert into users (username, authority) values ('bob', 'ROLE_USER');