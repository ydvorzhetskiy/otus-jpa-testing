create table person
(
    id          bigint,
    person_name varchar(255)
);

create sequence person_seq start with 1 increment by 1;

create table pet
(
    id       bigint,
    name     varchar(255),
    owner_id bigint
);

alter table pet
    add foreign key (owner_id)
        references person (id);

create sequence pet_seq start with 1 increment by 1;
