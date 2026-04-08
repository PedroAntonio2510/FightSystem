CREATE TABLE gym (
    id serial primary key,
    name varchar(100) not null,
    address varchar(100),
    created_at timestamp
);

CREATE TABLE member (
    id serial primary key,
    name varchar(100) not null,
    cpf varchar(11) unique not null,
    email varchar(155) not null ,
    birth_date date not null ,
    belt varchar(20),
    gym_id int,
    created_at timestamp,
    updated_at timestamp,
    FOREIGN KEY (gym_id) REFERENCES gym(id)
);

CREATE TABLE plan (
    id serial primary key,
    name varchar(100),
    price numeric(10,2),
    description text,
    gym_id int,
    month_duration integer,
    FOREIGN KEY (gym_id) REFERENCES gym(id)
);

CREATE TABLE class (
    id serial primary key,
    gym_id int,
    instructor_id int,
    name varchar(50),
    class_type varchar(50),
    start_time timestamp,
    created_at timestamp,
    updated_at timestamp,
    FOREIGN KEY (gym_id) REFERENCES gym(id)
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


