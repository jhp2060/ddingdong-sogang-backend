create table posts (
    id bigint not null auto_increment,
    created_date datetime,
    modified_date datetime,
    author varchar(255),
    content TEXT not null,
    title varchar(500) not null,
    primary key (id)
) engine=InnoDB;

create table site (
    id bigint not null auto_increment,
    name varchar(100) not null,
    url varchar(300) not null,
    primary key (id)
) engine=InnoDB;

create table board (
    id bigint not null auto_increment,
    name varchar(100) not null,
    url varchar(300) not null,
    site_id bigint, primary key (id)
) engine=InnoDB;

create table notice (
    id bigint not null auto_increment,
    created_date datetime,
    modified_date datetime,
    author varchar(20),
    content TEXT not null,
    posted_at datetime,
    title varchar(100) not null,
    url varchar(300),
    board_id bigint,
    primary key (id)
)engine=InnoDB;