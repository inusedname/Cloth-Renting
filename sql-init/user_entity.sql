create table user_entity
(
    id       bigint auto_increment
        primary key,
    email    varchar(255) null,
    password varchar(255) null,
    role     int          not null,
    username varchar(255) null
);

INSERT INTO clothes_renting.user_entity (id, email, password, role, username) VALUES (1, 'admin@gmail.com', '12345678', 1, 'admin');
INSERT INTO clothes_renting.user_entity (id, email, password, role, username) VALUES (2, 'user@gmail.com', '12345678', 0, 'user');
