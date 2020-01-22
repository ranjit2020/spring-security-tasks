insert into my_users (username,password,enabled) values ('alex','alex@123',true);
insert into my_users (username,password,enabled) values ('admin','admin@123',true);

insert into user_authorities(username,authority) values ('alex','ROLE_USER');
insert into user_authorities(username,authority) values ('admin','ROLE_ADMIN');