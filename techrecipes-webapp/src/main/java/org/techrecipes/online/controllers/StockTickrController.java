package org.techrecipes.online.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techrecipes.online.stockstreamer.StockDetailData;
import org.techrecipes.online.stockstreamer.StockTicklrSample;
import org.techrecipes.online.stockstreamer.StockTicklrSampleImpl;

import java.util.Optional;

@RestController
@RequestMapping("/lateststocks")
public class StockTickrController {
    @Autowired
    StockTicklrSampleImpl stockTicklrSample;
    public Optional<StockDetailData> getStockDetailData(){
        Optional<StockDetailData> detailData= stockTicklrSample.getPrice("AAPL");
        return detailData;
    }
}
