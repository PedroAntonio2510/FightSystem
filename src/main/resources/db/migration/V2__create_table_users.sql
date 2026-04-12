CREATE TABLE users(
        id serial primary key,
        name varchar(100) not null,
        email varchar(100) not null,
        password varchar(255) not null,
        role varchar(50) not null,
        created_at timestamp,
        updated_at timestamp
);