--TODO fix this query
create table product(
    id int primary key,
    name varchar2(100),
    description varchar2(255),
    CATEGORY_ID int,
    CREATED_AT date,
    MODIFIED_AT date,
    CREATED_BY varchar2(100),
    MODIFIED_BY VARCHAR2(100),
    PRODUCT_DETAILS_ID INT,
    QUANTITY int
);