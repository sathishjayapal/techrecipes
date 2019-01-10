package org.techrecipes.online.stockstreamer;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StockTicklrSampleImplTest {

    @Test
    void getPrice() {
        StockTicklrSample stockTicklrSample = new StockTicklrSampleImpl();
        Optional<StockDetailData> tickr = stockTicklrSample.getPrice("AAPL");
        Assert.assertTrue(tickr.isPresent());
    }
}