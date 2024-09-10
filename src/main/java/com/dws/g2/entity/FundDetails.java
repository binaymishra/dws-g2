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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fund_details")
public class FundDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "fund_name")
    private String fundName;

    @Column(name = "mornigstar_rating")
    private int mornigstarRating;

    @Column(name = "sharpe_ratio")
    private BigDecimal sharpeRatio;

    @Column(name = "tracking_error")
    private BigDecimal trackingError;

    @Column(name = "information_ratio")
    private BigDecimal informationRatio;

    @Column(name = "esg_score")
    private int esgScore;

    @Column(name = "sector")
    private String sector;

}
