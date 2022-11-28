create table user_profile (
                                     id bigserial not null,
                                     email varchar(250) not null unique,
                                     primary key (id)
);