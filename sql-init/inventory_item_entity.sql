create table inventory_item_entity
(
    id                bigint auto_increment
        primary key,
    last_update       datetime(6) null,
    quantity_in_stock int         not null,
    cloth_id          bigint      null,
    constraint UK_9q28rvl32e88gdo3y4vcr5ksw
        unique (cloth_id),
    constraint FKh777cros0bf3p6tjosut5f0cs
        foreign key (cloth_id) references cloth_entity (id)
);

INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (1, '2024-05-01 23:18:59.000000', 0, 1);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (2, '2024-05-01 23:18:59.000000', 0, 2);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (3, '2024-05-07 16:28:10.445105', 6, 3);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (4, '2024-05-30 16:42:58.613954', 7, 4);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (5, '2024-05-30 16:43:28.538925', 12, 5);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (6, '2024-05-01 23:18:59.000000', 0, 6);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (7, '2024-05-01 23:18:59.000000', 0, 7);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (8, '2024-05-01 23:18:59.000000', 0, 8);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (9, '2024-05-30 16:43:28.538925', 3, 9);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (10, '2024-05-01 23:18:59.000000', 0, 10);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (11, '2024-05-01 23:18:59.000000', 0, 11);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (12, '2024-05-01 23:18:59.000000', 0, 12);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (13, '2024-05-02 18:32:29.975643', 2, 13);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (14, '2024-05-07 16:28:10.445105', 4, 14);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (15, '2024-05-01 23:18:59.000000', 0, 15);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (16, '2024-05-07 16:28:10.445105', 5, 16);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (17, '2024-05-01 23:18:59.000000', 0, 17);
INSERT INTO clothes_renting.inventory_item_entity (id, last_update, quantity_in_stock, cloth_id) VALUES (18, '2024-05-07 16:24:37.782980', 3, 18);
