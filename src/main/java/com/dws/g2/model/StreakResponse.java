package com.dws.g2.model;

import lombok.Data;

import java.util.List;

@Data
public class StreakResponse {
    private int rank;
    private int score;
    private List<Boolean> streak;
}
