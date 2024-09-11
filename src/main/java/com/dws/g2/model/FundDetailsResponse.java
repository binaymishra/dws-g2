package com.dws.g2.model;

import lombok.Data;

@Data
public class FundDetailsResponse {
    private String fundName;
    private int mornigstarRating;
    private double sharpeRatio;
    private double trackingError;
    private double informationRatio;
    private int esgScore;
    private String sector;
}
