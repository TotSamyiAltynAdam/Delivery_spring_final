create table t_permissions(
    id   bigint auto_increment    primary key,
    role varchar(255) null
);

create table t_users(
    id        bigint auto_increment        primary key,
    email     varchar(255) null,
    full_name varchar(255) null,
    password  varchar(255) null,
    pre_order bit          null
);

create table t_users_permissions(
    user_id        bigint not null,
    permissions_id bigint not null,
    foreign key (user_id) references t_users (id),
    foreign key (permissions_id) references t_permissions (id)
);

create table t_categories(
    id   bigint auto_increment        primary key,
    name varchar(255) null
);

create table t_restaurants (
    id         bigint auto_increment        primary key,
    address    varchar(255) null,
    name       varchar(255) null,
    photo      varchar(255) null,
    ratings    int          null,
    user_email varchar(255) null
);

create table t_restaurants_category_list (
    restaurant_id    bigint not null,
    category_list_id bigint not null,
    foreign key (restaurant_id) references t_restaurants (id),
    foreign key (category_list_id) references t_categories (id)
);

create table t_dish_types (
    id   bigint auto_increment        primary key,
    name varchar(255) null
);


create table t_dishes (
    id            bigint auto_increment        primary key,
    description   text         null,
    name          varchar(255) null,
    photo         varchar(255) null,
    price         int          null,
    dish_type_id  bigint       null,
    restaurant_id bigint       null,
    foreign key (dish_type_id) references t_dish_types (id),
    foreign key (restaurant_id) references t_restaurants (id)
);

create table t_conditions (
    id   bigint auto_increment        primary key,
    type varchar(255) null
);

create table t_additional_blocks (
    id                bigint auto_increment        primary key,
    description       text         null,
    name              varchar(255) null,
    condition_type_id bigint       null,
    dish_id           bigint       null,
    foreign key (condition_type_id) references t_conditions (id),
    foreign key (dish_id) references t_dishes (id)
);

create table t_additional_dishes (
    id                  bigint auto_increment        primary key,
    name                varchar(255) null,
    price               int          null,
    additional_block_id bigint       null,
    foreign key (additional_block_id) references t_additional_blocks (id)
);













