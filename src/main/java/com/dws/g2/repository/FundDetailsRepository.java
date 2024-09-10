package com.dws.g2.repository;

import com.dws.g2.entity.FundDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundDetailsRepository extends JpaRepository<FundDetails, Integer> {

    @Query(value = "SELECT * from fund_details", nativeQuery = true)
    List<FundDetails> getAllFundDetails();
}
