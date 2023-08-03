CREATE TABLE users
(
    id          SERIAL PRIMARY KEY NOT NULL,
    family_name varchar(255)          NOT NULL,
    middle_name varchar(255)          NOT NULL,
    first_name  varchar(255)          NOT NULL,
    birthday    date                  NOT NULL,
    gender      char(1)               NOT NULL,
    age         int                   NOT NULL,
    description varchar(255)          NOT NULL,
    created     timestamp             NOT NULL,
    updated     timestamp             NOT NULL,
    is_blocked  boolean               NOT NULL
);