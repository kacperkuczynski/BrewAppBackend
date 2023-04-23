--liquibase formatted sql
--changeset kkuczynski:2
alter table recipe add slug varchar(255) after name_recipe;
alter table recipe add constraint ui_recipe_slug unique key(slug);