package org.techrecipes.online.stockstreamer;

import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(StreamTickerConfig.class)
class StockTickrStreamerServiceTest {

  @Autowired
  StockTickrStreamerService stockTickrStreamerService;

  @BeforeEach
  void setUp() {
  }

  @Test
  void getStockDetail() {
    Optional<StockDetailData> stockDetailData = stockTickrStreamerService.getStockDetail("AAPL");
    Assert.assertTrue(stockDetailData.isPresent());
  }

  @Test
  void getAllStockDetails() {
    List<StockDetailData> stockDetailDataList = stockTickrStreamerService.getAllStockDetails();
    Assert.assertTrue(stockDetailDataList.size() > 0);
  }
}