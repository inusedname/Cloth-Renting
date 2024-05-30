create table categories_of_cloth_entity
(
    id          bigint auto_increment
        primary key,
    category_id bigint null,
    cloth_id    bigint null,
    constraint FKd5759tmbxctgjyclaba40hsnr
        foreign key (category_id) references category_entity (id),
    constraint FKka7w5fmsn9bxxms9efvc8h369
        foreign key (cloth_id) references cloth_entity (id)
);

