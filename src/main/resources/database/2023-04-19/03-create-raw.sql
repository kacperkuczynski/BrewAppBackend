--liquibase formatted sql
--changeset kkuczynski:3
create table raw(
id bigint auto_increment not null PRIMARY KEY,
type_raw varchar(255) not null
);