create table financial_operation (
                                id bigserial not null,
                                account_id int8 not null,
                                operation_category_id int8,
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


--INSERT INTO financial_operation (account_id, operation_category_id, isSpending, amount)
--VALUES (1, 1, false, 100);
--
--INSERT INTO financial_operation (account_id, operation_category_id, isSpending, amount)
--VALUES (2, 2, false, 200);
--
--INSERT INTO financial_operation (account_id, operation_category_id, isSpending, amount)
--VALUES (3, 3, false, 300);
--
--INSERT INTO financial_operation (account_id, operation_category_id, isSpending, amount)
--VALUES (4, 4, true, 400);
--
--INSERT INTO financial_operation (account_id, operation_category_id, isSpending, amount)
--VALUES (5, 5, true, 500);