CREATE TABLE user_job_info
(
    id          SERIAL PRIMARY KEY NOT NULL,
    id_company int          NOT NULL,
    user_id int          NOT NULL,
    description varchar(255)          NOT NULL,
    is_activity  boolean               NOT NULL,
    created     timestamp             NOT NULL,
    updated     timestamp             NOT NULL
);