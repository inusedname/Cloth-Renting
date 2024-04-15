INSERT INTO seller_entity (id, name, email, telephone)
VALUES (1, 'Yody', 'a@gmail.com', '123'), (2, 'Nike', 'a@gmail.com', '123'), (3, 'Adidas', 'a@gmail.com', '123');

INSERT INTO category_entity (id, name)
VALUES (1, 'Size XL'), (2, 'Hồng'), (3, 'Thu Xuân 2024');

INSERT INTO cloth_entity (id, name, price, seller_id, preview_image, description)
VALUES (1, 'Áo thun', 100000, 1, 'https://dosi-in.com/images/detailed/42/CDL3_1.jpg', 'Thu xuân 2024'),
       (2, 'Áo sơ mi', 200000, 2, 'https://th.bing.com/th/id/OIP.7pfjWFSXSZdAOHqxL9mtwQHaLG?rs=1&pid=ImgDetMain', 'Fast Fashion'),
       (3, 'Quần jean', 300000, 3, 'https://afamilycdn.com/150157425591193600/2021/3/10/1530306901032039917589237871360618769515325n-16153480368581392256573.jpg', 'description'),
         (4, 'Quần kaki', 400000, 1, 'https://laforce.vn/wp-content/uploads/2022/07/phoi-do-voi-quan-jean-nam.jpg', 'description'),
         (5, 'Áo khoác', 500000, 2, 'https://laforce.vn/wp-content/uploads/2022/07/phoi-do-voi-quan-jean-nam.jpg', 'description'),
         (6, 'Áo len', 600000, 3, 'https://laforce.vn/wp-content/uploads/2022/07/phoi-do-voi-quan-jean-nam.jpg', 'description');
;