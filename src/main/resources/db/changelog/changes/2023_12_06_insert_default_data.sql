INSERT INTO t_permissions(role) VALUES('ROLE_ADMIN');
INSERT INTO t_permissions(role) VALUES('ROLE_RESTAURANT');
INSERT INTO t_permissions(role) VALUES('ROLE_USER');

INSERT INTO t_users(email, full_name, password, pre_order)
VALUES ('admin@gmail.com','Admin','$2a$08$UZ7fjWnXUfFaQSIyBKeOL.ds.yxFawu5KbK6utQ2pPtZ4yvK6JviC',false);

INSERT INTO t_users_permissions (user_id, permissions_id)
VALUES (1,1);

INSERT INTO t_users (id, email, full_name, password, pre_order) VALUES (2, 'eldosanarbaev7@gmail.com', 'Yeldos Anarbayev', '$2a$10$AcP3Qy3GbQ1/zuOWqHw1/Od/MPTz8gCj8vOTq0ze4ldX2ukgXRdr.', false);
INSERT INTO t_users (id, email, full_name, password, pre_order) VALUES (3, 'bahandi@gmail.com', 'Bahandi Bahandibai', '$2a$10$tVARf16O4pz9lIo.dfpE9Oo7neKX44k5OYMibQ1FF8LOHYtbBTiIe', false);

INSERT INTO t_users_permissions (user_id, permissions_id) VALUES (2, 3);
INSERT INTO t_users_permissions (user_id, permissions_id) VALUES (3, 2);
INSERT INTO t_users_permissions (user_id, permissions_id) VALUES (3, 3);


INSERT INTO t_categories (id, name) VALUES (1, 'asian');
INSERT INTO t_categories (id, name) VALUES (2, 'vegeterian');
INSERT INTO t_categories (id, name) VALUES (3, 'chinese');

INSERT INTO t_dish_types (id, name) VALUES (1, 'salad');
INSERT INTO t_dish_types (id, name) VALUES (2, 'meat');
INSERT INTO t_dish_types (id, name) VALUES (3, 'drink');
INSERT INTO t_dish_types (id, name) VALUES (4, 'soup');
INSERT INTO t_dish_types (id, name) VALUES (5, 'fast-food');

INSERT INTO t_conditions (id, type) VALUES (1, 'must');
INSERT INTO t_conditions (id, type) VALUES (2, 'desire');
INSERT INTO t_conditions (id, type) VALUES (3, 'remove');


INSERT INTO t_restaurants (id, address, name, photo, ratings, user_email) VALUES (1, 'BahandiAddress', 'Bahandi', '/media/dbImages/bahandi.png', 75, 'bahandi@gmail.com');
INSERT INTO t_restaurants (id, address, name, photo, ratings, user_email) VALUES (2, 'Burger King address', 'Burger King', '/media/dbImages/burgerKing.png', 0, 'burgerKing@gmail.com');
INSERT INTO t_restaurants (id, address, name, photo, ratings, user_email) VALUES (3, 'Gippo address', 'Gippo', '/media/dbImages/gippo.png', 0, 'gippo@gmail.com');
INSERT INTO t_restaurants (id, address, name, photo, ratings, user_email) VALUES (4, 'Zheka Doner House', 'Zheka Doner', '/media/dbImages/doner.png', 0, 'zhekaDoner@gmail.com');

INSERT INTO t_users (id, email, full_name, password, pre_order) VALUES (4, 'burgerKing@gmail.com', 'Burger Kinguly', '$2a$10$AcP3Qy3GbQ1/zuOWqHw1/Od/MPTz8gCj8vOTq0ze4ldX2ukgXRdr.', false);
INSERT INTO t_users_permissions (user_id, permissions_id) VALUES (4, 2);
INSERT INTO t_users_permissions (user_id, permissions_id) VALUES (4, 3);

INSERT INTO t_users (id, email, full_name, password, pre_order) VALUES (5, 'gippo@gmail.com', 'Gippo Gippobaev', '$2a$10$AcP3Qy3GbQ1/zuOWqHw1/Od/MPTz8gCj8vOTq0ze4ldX2ukgXRdr.', false);
INSERT INTO t_users_permissions (user_id, permissions_id) VALUES (5, 2);
INSERT INTO t_users_permissions (user_id, permissions_id) VALUES (5, 3);

INSERT INTO t_users (id, email, full_name, password, pre_order) VALUES (6, 'zhekaDoner@gmail.com', 'Zheka Fatbelly', '$2a$10$AcP3Qy3GbQ1/zuOWqHw1/Od/MPTz8gCj8vOTq0ze4ldX2ukgXRdr.', false);
INSERT INTO t_users_permissions (user_id, permissions_id) VALUES (6, 2);
INSERT INTO t_users_permissions (user_id, permissions_id) VALUES (6, 3);


INSERT INTO t_restaurants_category_list (restaurant_id, category_list_id) VALUES (1, 1);
INSERT INTO t_restaurants_category_list (restaurant_id, category_list_id) VALUES (2, 1);
INSERT INTO t_restaurants_category_list (restaurant_id, category_list_id) VALUES (3, 1);
INSERT INTO t_restaurants_category_list (restaurant_id, category_list_id) VALUES (4, 2);