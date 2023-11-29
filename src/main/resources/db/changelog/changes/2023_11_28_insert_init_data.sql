INSERT INTO t_permissions(role) VALUES('ROLE_ADMIN');
INSERT INTO t_permissions(role) VALUES('ROLE_RESTAURANT');
INSERT INTO t_permissions(role) VALUES('ROLE_USER');

INSERT INTO t_users(email, full_name, password, pre_order)
VALUES ('admin@gmail.com','Admin','$2a$08$UZ7fjWnXUfFaQSIyBKeOL.ds.yxFawu5KbK6utQ2pPtZ4yvK6JviC',false);

INSERT INTO t_users_permissions (user_id, permissions_id)
VALUES (1,1);


INSERT INTO t_restaurants (address, name, photo, ratings, user_email)
VALUES ('Bahandir address','Bahandi','pathtophoto', 0,'bahandi@gmail.com')
