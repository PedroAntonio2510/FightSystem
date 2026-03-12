CREATE TABLE member (
    id serial primary key,
    name varchar(100),
    cpf varchar(11) unique,
    email varchar(155),
    birth_date date,
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

CREATE TABLE enroll (
    id serial primary key,
    plan_id int,
    member_id int,
    start_date date,
    end_date date,
    enrolled boolean,
    FOREIGN KEY (plan_id) REFERENCES plan(id),
    FOREIGN KEY (member_id) REFERENCES member(id)
);


