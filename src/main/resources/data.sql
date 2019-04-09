-- After add @Entity to the User bean. Looking at the log, we see the following:
-- 
-- Hibernate: drop table user if exists
-- Hibernate: drop sequence if exists hibernate_sequence
-- Hibernate: create sequence hibernate_sequence start with 1 increment by 1
-- Hibernate: create table user (id integer not null, birth_date timestamp, name varchar(255), primary key (id))
-- 
-- So the table is created in the in-memory database

insert into user values (1, sysdate(), 'Hung');
insert into user values (2, sysdate(), 'Kaori');
insert into user values (3, sysdate(), 'Hieu');

-- After starting the application, use "/h2-console" to login
-- Ensure jdbc of "jdbc:h2:mem:testdb" and user name of "sa"