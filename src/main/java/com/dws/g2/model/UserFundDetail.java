package com.dws.g2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFundDetail {

    private int userId;
    private int fundId;
    private double contribution;
    private int contributionFrequency;
    private int boostFactor;
    private double contributionCap;
}
