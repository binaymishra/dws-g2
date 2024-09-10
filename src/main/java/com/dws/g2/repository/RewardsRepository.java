package com.dws.g2.repository;

import com.dws.g2.entity.Rewards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardsRepository extends JpaRepository<Rewards, Integer> {

    @Query(value = "select * from rewards order by reward desc limit 5", nativeQuery = true)
    List<Rewards> getTopRewards();

    @Query(value = "select * from rewards order by reward desc", nativeQuery = true)
    List<Rewards> getAllRewards();

    @Query(value = "select * from rewards where user_id = ?", nativeQuery = true)
    Rewards getRewardsByUserId(int userId);
}
