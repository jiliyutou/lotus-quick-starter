create table TB_EXAMPLE
(
    ID            INTEGER PRIMARY KEY auto_increment,
    KEY           VARCHAR(32),
    VALUE         CLOB,
    CREATED       TIMESTAMP NOT NULL,
    LAST_MODIFIED TIMESTAMP NOT NULL,
    UNIQUE INDEX uk (KEY, LAST_MODIFIED)
);
