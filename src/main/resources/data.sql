-- After add @Entity to the User bean. Looking at the log, we see the following:
-- 
-- Hibernate: drop table user if exists
-- Hibernate: drop sequence if exists hibernate_sequence
-- Hibernate: create sequence hibernate_sequence start with 1 increment by 1
-- Hibernate: create table user (id integer not null, birth_date timestamp, name varchar(255), primary key (id))
-- 
-- So the table is created in the in-memory database

-- Change to 10001 because "create sequence hibernate_sequence start with 1 increment by 1"
insert into user values (10001, sysdate(), 'Hung');
insert into user values (10002, sysdate(), 'Kaori');
insert into user values (10003, sysdate(), 'Hieu');

-- After starting the application, use "/h2-console" to login
-- Ensure jdbc of "jdbc:h2:mem:testdb" and user name of "sa"

-- Relationship database
insert into post values (11001, 'My first Post', 10001);
insert into post values (11002, 'My Second Post', 10001);