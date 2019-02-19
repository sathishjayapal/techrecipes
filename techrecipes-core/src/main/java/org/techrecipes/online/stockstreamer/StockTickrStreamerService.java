package org.techrecipes.online.stockstreamer;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

@Service
public class StockTickrStreamerService implements StockFileParser {
    Logger logger = LoggerFactory.getLogger(StockTickrStreamerService.class);

    @Autowired
    StockFileParser stockFileParser;

    public Optional<StockDetailData> getStockDetail(String tickrSymbol) {
        logger.debug("Debugging method start ==> StockTickrStreamerService.getStockDetail with Params [tickrSymbol].");
        String pathname = getTickrDailyFile();
        boolean doesExist = Files.isFile().apply(new File(pathname));
        System.out.println("StockTickrStreamerService.getStockDetail");
        logger.debug("Debugging method End ==> StockTickrStreamerService.getStockDetail with Params [tickrSymbol].");
        return Optional.empty();
    }
}
