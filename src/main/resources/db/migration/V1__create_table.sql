CREATE TABLE member (
    id serial primary key,
    name varchar(100) not null,
    cpf varchar(11) unique not null,
    email varchar(155) not null ,
    birth_date date not null ,
    belt varchar(20),
    created_at timestamp,
    updated_at timestamp
);

CREATE TABLE plan (
    id serial primary key,
    name varchar(100),
    price numeric(10,2),
    description text,
    month_duration integer
);

CREATE TYPE status AS ENUM ('ACTIVE', 'INACTIVE', 'CANCELLED');

CREATE TABLE enroll (
    id serial primary key,
    plan_id int,
    member_id int,
    start_date date,
    end_date date,
    enroll_status status,
    FOREIGN KEY (plan_id) REFERENCES plan(id),
    FOREIGN KEY (member_id) REFERENCES member(id)
);


