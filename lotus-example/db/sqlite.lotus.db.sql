create table tb_example
(
    id            integer not null primary key autoincrement,
    key           varchar(32),
    value         text,
    created       timestamp,
    last_modified timestamp
);

create unique index tb_example_key_uindex on tb_example (key);