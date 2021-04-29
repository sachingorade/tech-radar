create sequence project_id_seq start with 1 increment by 1;
create table projects (
    id bigint primary key,
    name varchar(128) not null,
    description varchar(512),
    repository_url varchar(1024),
    repository_type int
);