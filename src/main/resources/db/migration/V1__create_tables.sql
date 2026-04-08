CREATE TABLE gyms (
    id serial primary key,
    name varchar(50) not null,
    address varchar(100),
    created_at timestamp
);

CREATE TABLE members (
    id serial primary key,
    name varchar(100) not null,
    cpf varchar(11) unique not null,
    email varchar(155) not null ,
    birth_date date not null ,
    belt varchar(20),
    gym_id int,
    created_at timestamp,
    updated_at timestamp,
    FOREIGN KEY (gym_id) REFERENCES gyms(id)
);

CREATE TABLE plans (
    id serial primary key,
    name varchar(100),
    price numeric(10,2),
    description text,
    gym_id int,
    month_duration integer,
    FOREIGN KEY (gym_id) REFERENCES gyms(id)
);


CREATE TYPE status AS ENUM ('ACTIVE', 'INACTIVE', 'CANCELLED');

CREATE TABLE enroll (
    id serial primary key,
    plan_id int,
    member_id int,
    start_date date,
    end_date date,
    enroll_status status,
    FOREIGN KEY (plan_id) REFERENCES plans(id),
    FOREIGN KEY (member_id) REFERENCES members(id)
);


