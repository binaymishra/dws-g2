package com.dws.g2.repository;

import com.dws.g2.entity.UserFundDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFundDetailsRepository extends JpaRepository<UserFundDetails, Integer> {

    @Query(value = "SELECT * FROM user_fund_details WHERE user_id = ? and fund_id = ?", nativeQuery = true)
    UserFundDetails getUserFundDetailsByUserIdAndFundId(int userId, int fundId);
}
