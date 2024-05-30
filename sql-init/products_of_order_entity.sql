create table products_of_order_entity
(
    id             bigint auto_increment
        primary key,
    quantity       int    not null,
    snapshot_price bigint not null,
    cloth_id       bigint null,
    order_id       bigint null,
    constraint FK54tr360vcp5pq3yvdcfq37n9p
        foreign key (cloth_id) references cloth_entity (id),
    constraint FK86ow727mmjvebisedlsu0fbao
        foreign key (order_id) references buy_in_order_entity (id)
);

INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (1, 2, 20000, 1, 1);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (2, 3, 100000, 1, 1);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (3, 3, 50000, 2, 2);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (4, 1, 10000, 3, 2);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (5, 1, 279300, 3, 5);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (6, 2, 99000, 13, 5);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (7, 3, 99000, 14, 5);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (8, 4, 279300, 3, 6);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (9, 2, 99000, 16, 6);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (10, 3, 99000, 18, 6);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (11, 4, 279300, 3, 7);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (12, 3, 99000, 16, 7);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (13, 1, 99000, 14, 7);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (14, 1, 279300, 3, 7);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (15, 7, 1000000, 4, 8);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (16, 12, 500000, 5, 9);
INSERT INTO clothes_renting.products_of_order_entity (id, quantity, snapshot_price, cloth_id, order_id) VALUES (17, 3, 500000, 9, 9);
