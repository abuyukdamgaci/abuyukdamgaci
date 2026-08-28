create table tag
(
    id       bigint auto_increment primary key,
    name     varchar(255) not null
);

create table user_tag
(
    user_id    bigint,
    tag_id     bigint,
    primary key (user_id,tag_id),
    foreign key (user_id) references user (id) on delete cascade,
    foreign key (tag_id) references tag (id) on delete cascade
);

create table profile
(
    id       bigint primary key,
    bio     varchar(255) ,
    phone_number     varchar(15),
    date_of_birth     date,
    loyalty_point int default  0,
    constraint profile_user_id_fk
        foreign key (id) references user (id)
);