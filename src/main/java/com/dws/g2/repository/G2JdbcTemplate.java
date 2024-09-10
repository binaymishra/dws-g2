package com.dws.g2.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Slf4j
@Component("iamJdbcTemplate")
public class G2JdbcTemplate extends JdbcTemplate {

    public G2JdbcTemplate(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public <T> T queryForObject(String sql, Class<T> requiredType) {
        log.info("Executing query: {}", sql);
        return super.queryForObject(sql, requiredType);
    }
}
