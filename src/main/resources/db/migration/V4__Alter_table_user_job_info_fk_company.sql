ALTER TABLE user_job_info
    ADD CONSTRAINT fk_user_job_company FOREIGN KEY (id_company) REFERENCES company (id);