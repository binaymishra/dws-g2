package com.dws.g2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

/**
 * Basic StockMarketSimulation
 *
 * @author Binay Mishra
 */
@Component("stockMarketSimulation")
public class StockMarketSimulation {

  final Random rand = new Random(System.currentTimeMillis());
  final String STOCK_QUEUE = "/topic/stock";

  private TaskScheduler scheduler;

  private SimpMessagingTemplate template;

  @Autowired
  public StockMarketSimulation(TaskScheduler scheduler, SimpMessagingTemplate template) {
    this.scheduler = scheduler;
    this.template = template;
  }

  private void updateStockPrices(List<Stock> stockPrices) {
    for (Stock stock : stockPrices) {
      // Save last price
      stock.setOldPrice(stock.getPrice());
      double chgPct = rand.nextDouble() * 5.0;
      if (rand.nextInt(2) == 1) chgPct = -chgPct;
      // Update latest price
      stock.setPrice(stock.getPrice() + (chgPct / 100.0 * stock.getPrice()));
      stock.setDiff(stock.getOldPrice() - stock.getPrice());
    }
    template.convertAndSend(STOCK_QUEUE, stockPrices);
  }

  @PostConstruct
  public void broadcastEverySecond() {
    final List<Stock> stocks = new ArrayList<>(3);
    try {
      stocks.add(new Stock(1L, "IBM", 66.79, 66.79, 0.0));
      stocks.add(new Stock(2L, "TCS", 44.18, 44.18, 0.0));
      stocks.add(new Stock(3L, "HCL", 78.32, 78.32, 0.0));
      scheduler.scheduleAtFixedRate(() -> updateStockPrices(stocks), 2000);
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
