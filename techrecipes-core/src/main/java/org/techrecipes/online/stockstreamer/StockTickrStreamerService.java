package org.techrecipes.online.stockstreamer;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockTickrStreamerService {

  Logger logger = LoggerFactory.getLogger(StockTickrStreamerService.class);

  @Autowired
  StockFileParserImpl stockFileParserImpl;
  @Autowired
  Sample365FTPClient sample365FTPClient;

  public Optional<StockDetailData> getStockDetail(String tickrSymbol) {
    logger.debug(
        "Debugging method start ==> StockTickrStreamerService.getStockDetail with Params [tickrSymbol].");
    List<StockDetailData> detailData = allDetailData();
    Optional<StockDetailData> selectedData = detailData.stream()
        .filter(
            stockDetailData -> stockDetailData.getStockid().equalsIgnoreCase(tickrSymbol))
        .findFirst();
    System.out.println("StockTickrStreamerService.getStockDetail" + selectedData.get());
    logger.debug(
        "Debugging method End ==> StockTickrStreamerService.getStockDetail with Params [tickrSymbol].");
    return selectedData;
  }

  public List<StockDetailData> getAllStockDetails() {
    return allDetailData();
  }

  private List<StockDetailData> allDetailData() {
    logger.debug(
        "Debugging method start ==> StockTickrStreamerService.getStockDetail with Params [tickrSymbol].");
    Boolean downladSuccess = sample365FTPClient.downloadStockTickrFile();
    List<StockDetailData> detailData = Collections.EMPTY_LIST;
    if (downladSuccess) {
      detailData = stockFileParserImpl.parseStockFile();
    }
    return detailData;
  }
}
