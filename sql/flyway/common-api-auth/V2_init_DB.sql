create table user_credentials (
                                id bigserial not null,
                                userId bigint not null,
                                role varchar(16),
                                salt varchar(8) not null,
                                hash varchar(255) not null,
                                primary key (id)
);