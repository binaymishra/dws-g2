package com.dws.g2.repository;

import org.springframework.stereotype.Repository;

@Repository
public class GenericJdbcRepository {

    private final G2JdbcTemplate g2JdbcTemplate;

    public GenericJdbcRepository(G2JdbcTemplate g2JdbcTemplate) {
        this.g2JdbcTemplate = g2JdbcTemplate;
    }


}
