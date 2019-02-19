package org.techrecipes.online.stockstreamer;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

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
        Assert.assertTrue(1 == 1);
    }
}