INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'john.doe');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'admin.admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);

-- Populate random city table

INSERT INTO random_city(id, name) VALUES (1, 'Bamako');
INSERT INTO random_city(id, name) VALUES (2, 'Nonkon');
INSERT INTO random_city(id, name) VALUES (3, 'Houston');
INSERT INTO random_city(id, name) VALUES (4, 'Toronto');
INSERT INTO random_city(id, name) VALUES (5, 'New York City');
INSERT INTO random_city(id, name) VALUES (6, 'Mopti');
INSERT INTO random_city(id, name) VALUES (7, 'Koulikoro');
INSERT INTO random_city(id, name) VALUES (8, 'Moscow');

insert into station (id,name,power,marque, organisation) values (1,'rizomm 1',22, 'G2Mobility', 'la catho');
insert into station (id,name,power,marque, organisation) values (2,'rizomm 2',22, 'G2Mobility', 'la catho');

insert into car (id,marque, modele, autonomy,power_max,organisation, user_id, station_id) values (1,'renault','zoe',50,24,null,1,1);
insert into car (id,marque, modele, autonomy,power_max,organisation, user_id) values (2,'tesla','model S',50,24,null,2);
insert into car (id,marque, modele, autonomy,power_max,organisation, user_id) values (3,'BMW','i5',50,24,'la catho',null);



insert into reservation_car(id,date_start,date_end,user_id,car_id) values(1,'2019-06-01 10:00:00','2019-06-11 14:00:00' ,1,1);
insert into reservation_car(id,date_start,date_end,user_id,car_id) values(2,'2019-06-01 10:00:00','2019-06-11 14:00:00' ,1,2);

insert into reservation_station(id,date_start,date_end,user_id,station_id) values(1,'2019-06-01 10:00:00','2019-06-11 14:00:00' ,1,1);
insert into reservation_station(id,date_start,date_end,user_id,station_id) values(2,'2019-06-01 10:00:00','2019-06-11 14:00:00' ,1,2);