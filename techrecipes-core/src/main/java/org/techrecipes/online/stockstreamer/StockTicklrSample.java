package org.techrecipes.online.stockstreamer;
import java.util.Optional;
/**
 * Created by sjayapal on 12/21/2016.
 */
@FunctionalInterface
public interface StockTicklrSample {
    Optional<StockDetailData> getPrice(String symbol);
}
