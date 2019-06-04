INSERT INTO app_role (id, role_name, description) VALUES (10001, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (10002, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (10001, 'Jerome', 'Laquay', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'jeromelaquay');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (10002, 'Bernard', 'Dupondt', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'bernarddupondt');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (10003, 'fabien', 'Dubois', '$2a$10$qtH0F1m488673KwgAfFXEOWxsoZSeHqqlB/8BTt3a6gsI5c2mdlfe', 'fabiendubois');


INSERT INTO user_role(user_id, role_id) VALUES(10001,10001);
INSERT INTO user_role(user_id, role_id) VALUES(10002,10001);
INSERT INTO user_role(user_id, role_id) VALUES(10003,10001);
INSERT INTO user_role(user_id, role_id) VALUES(10003,10002);

insert into station (id,name,power,marque, organisation,longitude,latitude) values (10001,'rizomm 1',22, 'G2Mobility', 'la catho','0.0','0.0');
insert into station (id,name,power,marque, organisation,longitude,latitude) values (10002,'rizomm 2',11, 'G2Mobility', 'la catho','0.0','0.0');
insert into station (id,name,power,marque, organisation,longitude,latitude) values (10003,'yncrea 1',60, 'G2Mobility', 'yncrea','0.0','0.0');
insert into station (id,name,power,marque, organisation,longitude,latitude) values (10004,'yncrea 2',7.4, 'G2Mobility', 'yncrea','0.0','0.0');

insert into car (id,marque, modele, immatriculation, power_max,organisation, km_max, user_id) values (10001,'Renault','Zoé','CD-325-ZE',24,null, 150,10001);
insert into car (id,marque, modele, immatriculation, power_max,organisation, km_max, user_id) values (10002,'Tesla','model_S','AJ-672-BZ',150,null,800,10002);
insert into car (id,marque, modele, immatriculation, power_max,organisation, km_max, user_id) values (10003,'BMW','i5','AZ-999-NB',100,'la catho',600,null);
insert into car (id,marque, modele, immatriculation, power_max,organisation, km_max, user_id) values (10004,'Renault','Zoé','WZ-113-HG',24,'yncrea',150,null);

insert into reservation_car(id,date_start,date_end,user_id,car_id) values(10001,'2019-07-01 10:00:00','2019-07-01 12:00:00' ,10001,10001);
insert into reservation_car(id,date_start,date_end,user_id,car_id) values(10002,'2019-07-01 15:00:00','2019-07-01 18:00:00' ,10001,10001);

insert into reservation_car(id,date_start,date_end,user_id,car_id) values(10003,'2019-07-01 11:00:00','2019-07-01 13:00:00' ,10002,10002);
insert into reservation_car(id,date_start,date_end,user_id,car_id) values(10004,'2019-07-01 16:00:00','2019-07-01 19:00:00' ,10002,10002);

insert into reservation_station(id,date_start,date_end,user_id,station_id,car_id) values(10001,'2019-07-02 10:00:00','2019-07-02 14:00:00' ,10001,10001,10001);
insert into reservation_station(id,date_start,date_end,user_id,station_id,car_id) values(10002,'2019-07-02 18:00:00','2019-07-02 20:00:00' ,10001,10001,10001);

insert into reservation_station(id,date_start,date_end,user_id,station_id,car_id) values(10003,'2019-07-02 10:00:00','2019-07-02 14:00:00' ,10002,10002,10002);
insert into reservation_station(id,date_start,date_end,user_id,station_id,car_id) values(10004,'2019-07-02 10:00:00','2019-07-02 14:00:00' ,10002,10002,10002);