create table my_users(
	username varchar(50) not null primary key,
	password varchar(50) not null,
	enabled boolean not null
);

create table user_authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references my_users(username)
);
create unique index ix_auth_username on user_authorities (username,authority);