create table financial_operation (
                                id bigserial not null,
                                account_id bigint not null,
                                operation_category_id bigint,
                                isSpending boolean DEFAULT false,
                                amount numeric(19, 2),
                                dateTime timestamp,
                                primary key (id)
);

alter table if exists financial_operation
    add constraint financial_operation_fk_account
        foreign key (account_id) references account;

alter table if exists orders_details
    add constraint financial_operation_fk_operation_category
        foreign key (operation_category_id) references operation_category;


