package org.techrecipes.online.streams;
import org.techrecipes.online.stockstreamer.StockDetailData;
import org.techrecipes.online.stockstreamer.StockTicklrSampleImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
/**
 * Created by sjayapal on 2/16/2017.
 */
public class PredicateInterfaceSample {
    private static <T extends Consumer<? super T>> List<StockDetailData> filter(
            List<StockDetailData> tList,
            Predicate<StockDetailData>
                    tPredicate) {
        List<StockDetailData> results = new ArrayList<>();
        for (StockDetailData s : tList) {
            if (tPredicate.test(s)) {
                results.add(s);
            }
        }
        return results;
    }
    public static void main(String args[]) {
        List<StockDetailData> stockDetailDatas = new ArrayList<>();
        Predicate<StockDetailData> predicate = s -> !s.getStockTickr().equalsIgnoreCase("GOOG");
        stockDetailDatas.add(new StockTicklrSampleImpl().getPrice("YHOO").get());
        stockDetailDatas.add(new StockTicklrSampleImpl().getPrice("AAPL").get());
        stockDetailDatas.add(new StockTicklrSampleImpl().getPrice("GOOG").get());
        stockDetailDatas.add(new StockTicklrSampleImpl().getPrice("MSFT").get());
        stockDetailDatas.add(new StockTicklrSampleImpl().getPrice("FB").get());
        List results = PredicateInterfaceSample.filter(stockDetailDatas, predicate);
        System.out.println(results.size());
    }
}
