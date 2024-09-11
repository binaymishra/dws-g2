package com.dws.g2.model;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
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

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private double contribution;

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private int contributionFrequency;

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private int boostFactor;

    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private double contributionCap;
}
