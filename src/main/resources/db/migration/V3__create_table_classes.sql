CREATE TABLE classes (
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