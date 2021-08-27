# productdb 데이터베이스 생성
create database productdb default character set utf8 collate utf8_general_ci;

# offer table
create table offer (
    offer_id bigint not null auto_increment,
    name varchar(128) not null,
    email varchar(128) not null,
    text varchar(128) not null,
    primary key(offer_id)
) default character set utf8 collate utf8_general_ci;

#insert data
insert into offer (name, email, text) values ('alice', 'alice@naver.com', 'alice text');
insert into offer (name, email, text) values ('bob', 'bob@naver.com', 'bob text');
