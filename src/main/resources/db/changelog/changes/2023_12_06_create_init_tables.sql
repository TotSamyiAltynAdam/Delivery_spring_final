create table t_permissions
(
    id   bigint auto_increment
        primary key,
    role varchar(255) null
);

create table t_users
(
    id        bigint auto_increment
        primary key,
    email     varchar(255) null,
    full_name varchar(255) null,
    password  varchar(255) null,
    pre_order bit          null
);

create table t_users_permissions
(
    user_id        bigint not null,
    permissions_id bigint not null,
    constraint FK1aqgc2651y14fjqdvq9ytfwc1
        foreign key (user_id) references t_users (id),
    constraint FKpmfc242wvr5kwdv44324cdbna
        foreign key (permissions_id) references t_permissions (id)
);

create table t_restaurants
(
    id         bigint auto_increment
        primary key,
    address    varchar(255) null,
    name       varchar(255) null,
    photo      varchar(255) null,
    ratings    int          null,
    user_email varchar(255) null
);

create table t_categories
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table t_restaurants_category_list
(
    restaurant_id    bigint not null,
    category_list_id bigint not null,
    constraint FK8dmlk61mwc12ug4or95xseld4
        foreign key (restaurant_id) references t_restaurants (id),
    constraint FKfkgkm56dt2av005p7cbo0gxrl
        foreign key (category_list_id) references t_categories (id)
);

create table t_conditions
(
    id   bigint auto_increment
        primary key,
    type varchar(255) null
);

create table t_dish_types
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

create table t_dishes
(
    id            bigint auto_increment
        primary key,
    description   text         null,
    name          varchar(255) null,
    photo         varchar(255) null,
    price         int          null,
    dish_type_id  bigint       null,
    restaurant_id bigint       null,
    constraint FKiej820ky19gln0eqvmv1ysdl7
        foreign key (dish_type_id) references t_dish_types (id),
    constraint FKjppeaw11o710xcfximhjfcv0j
        foreign key (restaurant_id) references t_restaurants (id)
);

create table t_additional_blocks
(
    id                bigint auto_increment
        primary key,
    description       text         null,
    name              varchar(255) null,
    condition_type_id bigint       null,
    dish_id           bigint       null,
    constraint FK5pscs1suik6olhbfkbdqjhqlc
        foreign key (condition_type_id) references t_conditions (id),
    constraint FKcewhamf7eggtu5lyo061m8bns
        foreign key (dish_id) references t_dishes (id)
);

create table t_additional_dishes
(
    id                  bigint auto_increment
        primary key,
    name                varchar(255) null,
    price               int          null,
    additional_block_id bigint       null,
    constraint FKih5nju7dlbv0diw5dxq5k3h1f
        foreign key (additional_block_id) references t_additional_blocks (id)
);