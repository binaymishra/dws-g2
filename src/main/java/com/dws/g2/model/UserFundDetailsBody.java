package com.dws.g2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFundDetailsBody {
    private List<UserFundDetail> userFundDetails;
}
