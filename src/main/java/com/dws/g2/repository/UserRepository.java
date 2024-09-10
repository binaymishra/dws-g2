package com.dws.g2.repository;

import com.dws.g2.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT * from users where id = ?", nativeQuery = true)
    Users findById(int id);

    @Query(value = "SELECT * FROM USERS WHERE username = ?", nativeQuery = true)
    Users findByUsername(String username);
}
