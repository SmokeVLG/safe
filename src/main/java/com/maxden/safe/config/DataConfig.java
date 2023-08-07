package com.maxden.safe.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableJdbcAuditing
@EnableJpaRepositories
public class DataConfig {
}