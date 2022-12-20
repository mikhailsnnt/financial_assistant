CREATE TABLE Category
(
    id BIGINT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    category_name VARCHAR(255) NOT NULL,
    operation_type VARCHAR(5) NOT NULL
    constraint operation_type_c check (operation_type in ('income', 'spending','indeterminate'))
);
CREATE SEQUENCE IF NOT EXISTS Category START WITH 1 INCREMENT BY 1;
CREATE INDEX IF NOT EXISTS category_name_idx ON Catalog (lower(category_name) varchar_pattern_ops); /* efficient case-independent search  */