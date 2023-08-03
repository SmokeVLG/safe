ALTER TABLE user_job_info
    ADD CONSTRAINT fk_user_job_users FOREIGN KEY (user_id) REFERENCES users (id);