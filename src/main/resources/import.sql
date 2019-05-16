INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'Jerome', 'Laquay', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'jeromelaquay');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Bernard', 'Dupondt', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'bernarddupondt');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (3, 'fabien', 'Dubois', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'fabiendubois');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(3,1);
INSERT INTO user_role(user_id, role_id) VALUES(3,2);

insert into station (id,name,power,marque, organisation) values (1,'rizomm 1',22, 'G2Mobility', 'la catho');
insert into station (id,name,power,marque, organisation) values (2,'rizomm 2',11, 'G2Mobility', 'la catho');

insert into car (id,marque, modele, autonomy,power_max,organisation, user_id, station_id) values (1,'renault','zoe',200,24,null,1,1);
insert into car (id,marque, modele, autonomy,power_max,organisation, user_id) values (2,'tesla','model S',600,24,null,2);
insert into car (id,marque, modele, autonomy,power_max,organisation, user_id) values (3,'BMW','i5',300,24,'la catho',null);

insert into reservation_car(id,date_start,date_end,user_id,car_id) values(1,'2019-06-01 10:00:00','2019-06-01 12:00:00' ,1,1);
insert into reservation_car(id,date_start,date_end,user_id,car_id) values(2,'2019-06-01 15:00:00','2019-06-01 18:00:00' ,1,1);

insert into reservation_car(id,date_start,date_end,user_id,car_id) values(3,'2019-06-01 11:00:00','2019-06-01 13:00:00' ,2,2);
insert into reservation_car(id,date_start,date_end,user_id,car_id) values(4,'2019-06-01 16:00:00','2019-06-01 19:00:00' ,2,2);

insert into reservation_station(id,date_start,date_end,user_id,station_id) values(1,'2019-06-01 10:00:00','2019-06-01 14:00:00' ,1,1,1);
insert into reservation_station(id,date_start,date_end,user_id,station_id) values(2,'2019-06-01 18:00:00','2019-06-01 20:00:00' ,1,1,1);

insert into reservation_station(id,date_start,date_end,user_id,station_id) values(3,'2019-06-01 10:00:00','2019-06-01 14:00:00' ,2,2,2);
insert into reservation_station(id,date_start,date_end,user_id,station_id) values(4,'2019-06-01 10:00:00','2019-06-01 14:00:00' ,2,2,2);