package com.academix.academix.data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfigCollegify {

    @Bean(name = "collegifyDataSource")
    public DataSource collegifyDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:8889/Collegify1")
                .username("root")
                .password("root")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean(name = "collegifyJdbcTemplate")
    public JdbcTemplate collegifyJdbcTemplate(@Qualifier("collegifyDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}