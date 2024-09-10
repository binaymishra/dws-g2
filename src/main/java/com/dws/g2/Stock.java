package com.dws.g2;

import lombok.AllArgsConstructor;
import lombok.Data;

/** @author Binay Mishra */
@Data
@AllArgsConstructor
public class Stock {
  private Long id;
  private String name;
  private Double oldPrice;
  private Double price;
  private Double diff;
}
