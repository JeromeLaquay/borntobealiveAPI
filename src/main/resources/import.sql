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
insert into station (id,name,power,marque, organisation) values (3,'yncrea 1',60, 'G2Mobility', 'yncrea');
insert into station (id,name,power,marque, organisation) values (4,'yncrea 2',7.4, 'G2Mobility', 'yncrea');

insert into car (id,marque, modele, immatriculation, power_max,organisation, km_max, user_id) values (1,'Renault','Zoé','CD-325-ZE',24,null, 150,1);
insert into car (id,marque, modele, immatriculation, power_max,organisation, km_max, user_id) values (2,'Tesla','model_S','AJ-672-BZ',150,null,800,2);
insert into car (id,marque, modele, immatriculation, power_max,organisation, km_max, user_id) values (3,'BMW','i5','AZ-999-NB',100,'la catho',600,null);
insert into car (id,marque, modele, immatriculation, power_max,organisation, km_max, user_id) values (4,'Renault','Zoé','WZ-113-HG',24,'yncrea',150,null);

insert into reservation_car(id,date_start,date_end,user_id,car_id) values(1,'2019-07-01 10:00:00','2019-07-01 12:00:00' ,1,1);
insert into reservation_car(id,date_start,date_end,user_id,car_id) values(2,'2019-07-01 15:00:00','2019-07-01 18:00:00' ,1,1);

insert into reservation_car(id,date_start,date_end,user_id,car_id) values(3,'2019-07-01 11:00:00','2019-07-01 13:00:00' ,2,2);
insert into reservation_car(id,date_start,date_end,user_id,car_id) values(4,'2019-07-01 16:00:00','2019-07-01 19:00:00' ,2,2);

insert into reservation_station(id,date_start,date_end,user_id,station_id,car_id) values(1,'2019-07-02 10:00:00','2019-07-02 14:00:00' ,1,1,1);
insert into reservation_station(id,date_start,date_end,user_id,station_id,car_id) values(2,'2019-07-02 18:00:00','2019-07-02 20:00:00' ,1,1,1);

insert into reservation_station(id,date_start,date_end,user_id,station_id,car_id) values(3,'2019-07-02 10:00:00','2019-07-02 14:00:00' ,2,2,2);
insert into reservation_station(id,date_start,date_end,user_id,station_id,car_id) values(4,'2019-07-02 10:00:00','2019-07-02 14:00:00' ,2,2,2);