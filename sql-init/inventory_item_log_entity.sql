create table inventory_item_log_entity
(
    id                bigint auto_increment
        primary key,
    action            varchar(255) null,
    date              datetime(6)  null,
    quantity          int          not null,
    inventory_item_id bigint       null,
    user_id           bigint       null,
    constraint FK2pjuuvv1hleff7a7t830u4rvs
        foreign key (user_id) references user_entity (id),
    constraint FK8if7siqqgxn4gt487k00ocyk
        foreign key (inventory_item_id) references inventory_item_entity (id)
);

INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (1, 'BUY_IN', '2024-05-02 18:32:29.975643', 1, 3, 1);
INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (2, 'BUY_IN', '2024-05-02 18:32:29.975643', 2, 13, 1);
INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (3, 'BUY_IN', '2024-05-02 18:32:29.975643', 3, 14, 1);
INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (4, 'BUY_IN', '2024-05-07 16:24:37.782980', 4, 3, 1);
INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (5, 'BUY_IN', '2024-05-07 16:24:37.782980', 2, 16, 1);
INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (6, 'BUY_IN', '2024-05-07 16:24:37.782980', 3, 18, 1);
INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (7, 'BUY_IN', '2024-05-07 16:28:10.445105', 1, 3, 1);
INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (8, 'BUY_IN', '2024-05-07 16:28:10.445105', 3, 16, 1);
INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (9, 'BUY_IN', '2024-05-07 16:28:10.445105', 1, 14, 1);
INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (10, 'BUY_IN', '2024-05-30 16:42:58.613954', 7, 4, 1);
INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (11, 'BUY_IN', '2024-05-30 16:43:28.538925', 12, 5, 1);
INSERT INTO clothes_renting.inventory_item_log_entity (id, action, date, quantity, inventory_item_id, user_id) VALUES (12, 'BUY_IN', '2024-05-30 16:43:28.538925', 3, 9, 1);
