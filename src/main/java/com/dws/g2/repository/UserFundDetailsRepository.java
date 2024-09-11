package com.dws.g2.repository;

import com.dws.g2.entity.UserFundDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFundDetailsRepository extends JpaRepository<UserFundDetails, Integer> {
}
