create table student (
       id BIGINT(11) UNSIGNED not null auto_increment,
        email varchar(255),
        mobile varchar(255),
        name varchar(255) not null,
        primary key (id)
    ) engine=InnoDB
