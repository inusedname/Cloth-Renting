create table seller_entity
(
    id        bigint auto_increment
        primary key,
    address   varchar(255) null,
    email     varchar(255) null,
    name      varchar(255) null,
    note      varchar(255) null,
    telephone varchar(255) null
);

INSERT INTO clothes_renting.seller_entity (id, address, email, name, note, telephone) VALUES (1, '308 Phan Trọng Tuệ, xã Thanh Liệt huyện Thanh Trì', 'chamsockhachhang@yody.vn', 'Yody Thanh Trì', null, '024 999 86 999');
INSERT INTO clothes_renting.seller_entity (id, address, email, name, note, telephone) VALUES (2, 'Đường Ngô Thì Nhậm kéo dài, Phường Dương Nội, Quận Hà Đông, Hà Nội', 'uniqlo@gmail.com', 'UNIQLO AEON MALL Ha Dong', null, '024 3207 9059');
INSERT INTO clothes_renting.seller_entity (id, address, email, name, note, telephone) VALUES (3, 'Tran Phu ST A9 Km10', 'adidas@gmail.com', 'ADIDAS STORE HA NOI, TRAN PHU ST', null, '024 33540816');
INSERT INTO clothes_renting.seller_entity (id, address, email, name, note, telephone) VALUES (4, 'Hà Nội', 'nike@gmail.com', 'Nike Store', null, '0123456789');
INSERT INTO clothes_renting.seller_entity (id, address, email, name, note, telephone) VALUES (5, '27 Co Linh, Long Bien, Hà Nội', 'zara@gmail.com', 'ZARA AEON MALL Long Bien', null, '0123456789');
INSERT INTO clothes_renting.seller_entity (id, address, email, name, note, telephone) VALUES (6, '27 Co Linh, Long Bien, Hà Nội', 'hm@gmail.com', 'H&M Royal City Ha Noi', null, '0123456789');
INSERT INTO clothes_renting.seller_entity (id, address, email, name, note, telephone) VALUES (7, '27 Co Linh, Long Bien, Hà Nội', 'puma@gmail.com', 'PUMA Lotte Tây Hồ', null, '0123456789');
INSERT INTO clothes_renting.seller_entity (id, address, email, name, note, telephone) VALUES (8, '27 Co Linh, Long Bien, Hà Nội', 'gucci@gmail.com', 'GUCCI Shimaben', null, '0123456789');
