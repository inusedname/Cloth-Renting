create table category_entity
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
);

INSERT INTO clothes_renting.category_entity (id, name) VALUES (1, 'Size XL');
INSERT INTO clothes_renting.category_entity (id, name) VALUES (2, 'Hồng');
INSERT INTO clothes_renting.category_entity (id, name) VALUES (3, 'Thu Xuân 2024');
