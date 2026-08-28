create table user
(
    id       bigint auto_increment
        primary key,
    name     varchar(255) not null,
    email    varchar(255) null,
    password varchar(255) null
);

create table address
(
    id      bigint auto_increment
        primary key,
    street  varchar(255) not null,
    city    varchar(255) not null,
    zip     bigint       not null,
    user_id bigint       not null,
    constraint address_user_id_fk
        foreign key (user_id) references user (id)
);

