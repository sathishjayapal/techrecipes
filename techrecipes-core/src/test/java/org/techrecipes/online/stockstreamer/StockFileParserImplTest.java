package org.techrecipes.online.stockstreamer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockFileParserImplTest {

    @Test
    void parseStockFile() {
        StockFileParser stockDetailData = new StockFileParserImpl();
        stockDetailData.parseStockFile("");
    }
}