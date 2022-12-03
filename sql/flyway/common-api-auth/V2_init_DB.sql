create table users(
                                id bigserial not null,
                                email varchar(250) not null unique,
                                role varchar(16),
                                salt varchar(8) not null,
                                hash varchar(255) not null,
                                primary key (id)
);