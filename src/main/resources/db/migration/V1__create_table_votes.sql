create table votes(
user_id varchar (36) NOT NULL PRIMARY KEY ,
value varchar (1) NOT NULL ,
check (value in ('Y','N'))
)