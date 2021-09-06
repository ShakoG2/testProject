create table public.users (
	id         bigserial primary key,
	first_name varchar(128),
	last_name  varchar(128),
	email      varchar(128),
	password   varchar(128),
	user_name  varchar(128) not null
)