CREATE TABLE company
(
    id          SERIAL PRIMARY KEY NOT NULL,
    company_name varchar(255)          NOT NULL,
    description varchar(255)          NOT NULL,
    created     timestamp             NOT NULL,
    updated     timestamp             NOT NULL,
    is_activity  boolean               NOT NULL
);