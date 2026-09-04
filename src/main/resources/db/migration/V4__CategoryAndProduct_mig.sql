CREATE TABLE CATEGORY(
    ID tinyint auto_increment primary key,
    NAME  VARCHAR(255) not null
);

CREATE TABLE PRODUCT(
    ID bigint auto_increment primary key,
    NAME   VARCHAR(255) not null,
    PRICE   decimal(10,2) not null,
    category_id tinyint,
    constraint fk_category foreign key (category_id) references CATEGORY (id) on delete cascade
);