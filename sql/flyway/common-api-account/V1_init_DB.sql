create table user_accounts (
                                     id bigserial not null,
                                     account_id bigint not null,
                                     name varchar(250),
                                     currency varchar(5),
                                     primary key (id),
                                     constraint user_accounts_fk_account foreign key (account_id) references users(id)



);
