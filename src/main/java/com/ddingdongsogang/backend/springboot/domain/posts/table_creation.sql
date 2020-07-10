create table posts (
    id bigint not null auto_increment,
    created_date datetime,
    modified_date datetime,
    author varchar(255),
    content TEXT not null,
    title varchar(500) not null,
    primary key (id)
) engine=InnoDB;