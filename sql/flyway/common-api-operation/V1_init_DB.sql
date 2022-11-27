create table financial_operation (
                                id bigserial not null,
                                account_id bigint not null,
                                operation_category_id bigint,
                                isSpending boolean DEFAULT false,
                                amount numeric(19, 2),
                                dateTime timestamp,
                                primary key (id)
);




