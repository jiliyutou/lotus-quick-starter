create table TB_EXAMPLE
(
    ID            INTEGER default NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_42265542_8C44_4B53_9052_C2274D52C051" auto_increment,
    KEY           VARCHAR(32)
unique,
    VALUE         CLOB,
    CREATED       TIMESTAMP(29, 9),
    LAST_MODIFIED TIMESTAMP(29, 9),
    constraint TABLE_NAME_PK
primary key (ID)
);
