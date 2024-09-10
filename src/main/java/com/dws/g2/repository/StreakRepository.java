package com.dws.g2.repository;

import com.dws.g2.entity.Streaks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreakRepository extends JpaRepository<Streaks, Integer> {

    @Query(value = "SELECT * FROM streaks WHERE user_id = ?", nativeQuery = true)
    List<Streaks> getStreaksByUserId(int userId);
}
