INSERT INTO user_entity (id, username, email, password, `role`)
VALUES (1, 'admin', 'admin@gmail.com', 'admin', 1), (2, 'user', 'user@gmail.com', 'user', 0);

INSERT INTO seller_entity (id, name, email, telephone, address)
VALUES (1, 'Yody Thanh Trì', 'chamsockhachhang@yody.vn', '024 999 86 999', '308 Phan Trọng Tuệ, xã Thanh Liệt huyện Thanh Trì'),
       (2, 'UNIQLO AEON MALL Ha Dong', 'uniqlo@gmail.com', '024 3207 9059', 'Đường Ngô Thì Nhậm kéo dài, Phường Dương Nội, Quận Hà Đông, Hà Nội'),
       (3, 'ADIDAS STORE HA NOI, TRAN PHU ST', 'adidas@gmail.com', '024 33540816', 'Tran Phu ST A9 Km10'),
       (4, 'Nike Store', 'nike@gmail.com', '0123456789', 'Hà Nội'),
       (5, 'ZARA AEON MALL Long Bien', 'zara@gmail.com', '0123456789', '27 Co Linh, Long Bien, Hà Nội'),
       (6, 'H&M Royal City Ha Noi', 'hm@gmail.com', '0123456789', '27 Co Linh, Long Bien, Hà Nội'),
       (7, 'PUMA Lotte Tây Hồ', 'puma@gmail.com', '0123456789', '27 Co Linh, Long Bien, Hà Nội'),
       (8, 'GUCCI Shimaben', 'gucci@gmail.com', '0123456789', '27 Co Linh, Long Bien, Hà Nội');

INSERT INTO category_entity (id, name)
VALUES (1, 'Size XL'), (2, 'Hồng'), (3, 'Thu Xuân 2024');

INSERT INTO cloth_entity (name, price, seller_id, preview_image, description)
VALUES ('Áo Thun Cổ Tròn Ngắn Tay', 195000, 2, 'https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/422992/item/vngoods_11_422992.jpg?width=750', 'Limited Offer Từ 26 Apr 2024 - 02 May 2024'),
       ('Miracle Air Quần Short (AirSense Quần Short)',588000, 2, 'https://image.uniqlo.com/UQ/ST3/vn/imagesgoods/455537/item/vngoods_56_455537.jpg?width=750', 'Limited Offer Từ 26 Apr 2024 - 02 May 2024'),
       ('Quần Jeans Kid Khaki Suông Túi Ốp', 279300 , 1, 'https://m.yodycdn.com/fit-in/filters:format(webp)/products/quan-kaki-tre-em-yody-qjk6014-bsa-apk6128-xla-7-of-10.jpg', 'Thành phần vải chính: 97% Cotton, 3% Spandex\nThành phần vải lót: 80% polyester, 20%cotton\nQuần kaki trẻ em cho cảm giác mặc thông thoáng, thấm hút tốt do có chứa thành phần cotton'),
        ('Giày classic cua Nike', 1000000, 4, 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/acn7004-cam-6.jpg?v=1714533314633', 'Giày classic cua Nike'),
        ('Áo thun nam Zara', 500000, 5, 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/bo-do-he-tre-em-yody-bdk7160-tpc-2.jpg?v=1712716502410', 'Áo thun nam Zara'),
        ('Áo thun nam H&M', 500000, 6, 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/bo-do-he-tre-em-yody-bdk7160-tpc-2.jpg?v=1712716502410', 'Áo thun nam H&M'),
        ('Giày thể thao Puma', 1000000, 7, 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Giày thể thao Puma'),
        ('Túi xách Gucci', 1000000, 8, 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Túi xách Gucci'),
        ('Áo thun BST Hè 2024 Zara', 500000, 5, 'https://https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Áo thun BST Hè 2024 Zara'),
        ('Áo thun BST Hè 2024 H&M', 500000, 6, 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Áo thun BST Hè 2024 H&M'),
        ('Áo thun BST Hè 2024 Puma', 500000, 7, 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Áo thun BST Hè 2024 Puma'),
        ('Áo thun BST Hè 2024 Gucci', 500000, 8, 'https://m.yodycdn.com/https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Áo thun BST Hè 2024 Gucci'),
        ('Yody Dép Xỏ Ngón Nữ', 99000, 1, 'https://m.yodycdn.com/fit-in/filters:format(webp)/https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Yody Dép Xỏ Ngón Nữ'),
        ('Yody Dép Xỏ Ngón Nam', 99000, 1, 'https://m.yodycdn.com/fit-in/filters:format(webp)/products/https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Yody Dép Xỏ Ngón Nam'),
        ('Yody Dép Xỏ Ngón Trẻ Em', 99000, 1, 'https://m.yodycdn.com/fit-in/filters:format(webp)/products/https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Yody Dép Xỏ Ngón Trẻ Em'),
        ('Yody Dép Xỏ Ngón Nữ', 99000, 1, 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Yody Dép Xỏ Ngón Nữ'),
        ('Yody Dép Xỏ Ngón Nam', 99000, 1, 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Yody Dép Xỏ Ngón Nam'),
        ('Yody Dép Xỏ Ngón Trẻ Em', 99000, 1, 'https://bizweb.dktcdn.net/thumb/large/100/438/408/products/ao-thun-nu-yoguu-co-cao-yodygut7028-nau-sjn6004-xah-3.jpg?v=1708998641850', 'Yody Dép Xỏ Ngón Trẻ Em');
INSERT INTO inventory_item_entity (id, cloth_id, quantity_in_stock, last_update)
VALUES (1, 1, 0, NOW()),
       (2, 2, 0, NOW()),
       (3, 3, 0, NOW()),
       (4, 4, 0, NOW()),
       (5, 5, 0, NOW()),
       (6, 6, 0, NOW()),
       (7, 7, 0, NOW()),
       (8, 8, 0, NOW()),
       (9, 9, 0, NOW()),
       (10, 10, 0, NOW()),
       (11, 11, 0, NOW()),
       (12, 12, 0, NOW()),
       (13, 13, 0, NOW()),
       (14, 14, 0, NOW()),
       (15, 15, 0, NOW()),
       (16, 16, 0, NOW()),
       (17, 17, 0, NOW()),
       (18, 18, 0, NOW());