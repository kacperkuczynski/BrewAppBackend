--liquibase formatted sql
--changeset kkuczynski:1
create table recipe (
id bigint not null auto_increment PRIMARY KEY,
number_recipe int(2) not null,
name_recipe varchar(255) not null
);