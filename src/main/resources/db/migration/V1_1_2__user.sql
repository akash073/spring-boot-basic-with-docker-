create table user (
       id BIGINT(11) UNSIGNED not null auto_increment,
        username varchar(255),
        password varchar(255),
        role varchar(255) not null,
        primary key (id)
    ) engine=InnoDB
