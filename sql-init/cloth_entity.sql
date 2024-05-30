create table cloth_entity
(
    id            bigint auto_increment
        primary key,
    description   varchar(255) null,
    name          varchar(255) null,
    preview_image varchar(255) null,
    price         bigint       not null,
    seller_id     bigint       not null,
    constraint FK9ak1e3mfpxo7gai1guxcrqunv
        foreign key (seller_id) references seller_entity (id)
);

INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (1, 'Limited Offer Từ 26 Apr 2024 - 02 May 2024', 'Áo Thun Cổ Tròn Ngắn Tay', 'https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/422992/item/vngoods_11_422992.jpg?width=750', 195000, 2);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (2, 'Limited Offer Từ 26 Apr 2024 - 02 May 2024', 'Miracle Air Quần Short (AirSense Quần Short)', 'https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/455537/item/vngoods_56_455537.jpg?width=750', 588000, 2);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (3, 'Thành phần vải chính: 97% Cotton, 3% Spandex
Thành phần vải lót: 80% polyester, 20%cotton
Quần kaki trẻ em cho cảm giác mặc thông thoáng, thấm hút tốt do có chứa thành phần cotton', 'Quần Jeans Kid Khaki Suông Túi Ốp', 'https://m.yodycdn.com/fit-in/filters:format(webp)/products/quan-kaki-tre-em-yody-qjk6014-bsa-apk6128-xla-7-of-10.jpg', 279300, 1);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (4, 'Giày classic cua Nike', 'Giày classic cua Nike', 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/acn7004-cam-6.jpg?v=1714533314633', 1000000, 4);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (5, 'Áo thun nam Zara', 'Áo thun nam Zara', 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/bo-do-he-tre-em-yody-bdk7160-tpc-2.jpg?v=1712716502410', 500000, 5);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (6, 'Áo thun nam H&M', 'Áo thun nam H&M', 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/bo-do-he-tre-em-yody-bdk7160-tpc-2.jpg?v=1712716502410', 500000, 6);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (7, 'Giày thể thao Puma', 'Giày thể thao Puma', 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 1000000, 7);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (8, 'Túi xách Gucci', 'Túi xách Gucci', 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 1000000, 8);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (9, 'Áo thun BST Hè 2024 Zara', 'Áo thun BST Hè 2024 Zara', 'https://https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 500000, 5);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (10, 'Áo thun BST Hè 2024 H&M', 'Áo thun BST Hè 2024 H&M', 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 500000, 6);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (11, 'Áo thun BST Hè 2024 Puma', 'Áo thun BST Hè 2024 Puma', 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 500000, 7);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (12, 'Áo thun BST Hè 2024 Gucci', 'Áo thun BST Hè 2024 Gucci', 'https://m.yodycdn.com/https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 500000, 8);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (13, 'Yody Dép Xỏ Ngón Nữ', 'Yody Dép Xỏ Ngón Nữ', 'https://m.yodycdn.com/fit-in/filters:format(webp)/https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 99000, 1);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (14, 'Yody Dép Xỏ Ngón Nam', 'Yody Dép Xỏ Ngón Nam', 'https://m.yodycdn.com/fit-in/filters:format(webp)/products/https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 99000, 1);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (15, 'Yody Dép Xỏ Ngón Trẻ Em', 'Yody Dép Xỏ Ngón Trẻ Em', 'https://m.yodycdn.com/fit-in/filters:format(webp)/products/https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 99000, 1);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (16, 'Yody Dép Xỏ Ngón Nữ', 'Yody Dép Xỏ Ngón Nữ', 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 99000, 1);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (17, 'Yody Dép Xỏ Ngón Nam', 'Yody Dép Xỏ Ngón Nam', 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 99000, 1);
INSERT INTO clothes_renting.cloth_entity (id, description, name, preview_image, price, seller_id) VALUES (18, 'Yody Dép Xỏ Ngón Trẻ Em', 'Yody Dép Xỏ Ngón Trẻ Em', 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 99000, 1);
