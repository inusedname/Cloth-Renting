create table buy_in_order_entity
(
    id        bigint auto_increment
        primary key,
    date      datetime(6) null,
    seller_id bigint      null,
    user_id   bigint      null,
    constraint FK5h8la6rv5phg0xjiie3bexnf
        foreign key (user_id) references user_entity (id),
    constraint FKsy717muy9u03a0mpkkf991osg
        foreign key (seller_id) references seller_entity (id)
);

INSERT INTO clothes_renting.buy_in_order_entity (id, date, seller_id, user_id) VALUES (1, '2024-05-02 16:45:20.000000', 1, 1);
INSERT INTO clothes_renting.buy_in_order_entity (id, date, seller_id, user_id) VALUES (2, '2024-05-02 16:45:35.000000', 2, 2);
INSERT INTO clothes_renting.buy_in_order_entity (id, date, seller_id, user_id) VALUES (3, '2024-05-02 16:45:46.000000', 1, 1);
INSERT INTO clothes_renting.buy_in_order_entity (id, date, seller_id, user_id) VALUES (5, '2024-05-02 18:32:29.975643', 1, 1);
INSERT INTO clothes_renting.buy_in_order_entity (id, date, seller_id, user_id) VALUES (6, '2024-05-07 16:24:37.782980', 1, 1);
INSERT INTO clothes_renting.buy_in_order_entity (id, date, seller_id, user_id) VALUES (7, '2024-05-07 16:28:10.445105', 1, 1);
INSERT INTO clothes_renting.buy_in_order_entity (id, date, seller_id, user_id) VALUES (8, '2024-05-30 16:42:58.613954', 4, 1);
INSERT INTO clothes_renting.buy_in_order_entity (id, date, seller_id, user_id) VALUES (9, '2024-05-30 16:43:28.538925', 5, 1);
