package com.dws.g2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "user_fund_details")
public class UserFundDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "fund_id")
    private int fundId;

    @Column(name = "contribution")
    private Double contribution;

    @Column(name = "contribution_frequency")
    private int contributionFrequency;

    @Column(name = "boost_factor")
    private int boostFactor;

    @Column(name = "contribution_cap")
    private Double contributionCap;
}
