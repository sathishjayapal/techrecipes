package org.techrecipes.online.stockstreamer;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
/**
 * Created by sjayapal on 5/11/2017.
 */
public class StockStreamSplitIterator implements Spliterator<StockDetailData> {
    private final List<StockDetailData> stockTickrList;
    private int currentTickr = 0;
    StockStreamSplitIterator(List<StockDetailData> stockDetailDatas) {
        this.stockTickrList = stockDetailDatas;
    }
    @Override
    public boolean tryAdvance(Consumer<? super StockDetailData> action) {
        action.accept(stockTickrList.get(currentTickr++));
        return currentTickr < stockTickrList.size();
    }
    @Override
    public Spliterator<StockDetailData> trySplit() {
        int tickrListLength = stockTickrList.size();
        int currentSize = stockTickrList.size() - currentTickr;
        if (currentSize < 100) {
            return null;
        }
        for (int splitPos = currentSize / 2 + currentTickr; splitPos < tickrListLength;
                splitPos++) {
            if (stockTickrList.get(splitPos) != null) {
                Spliterator<StockDetailData> spliterator =
                        new StockStreamSplitIterator(
                                stockTickrList.subList(currentTickr, splitPos));
                currentTickr = splitPos;
                return spliterator;
            }
        }
        return null;
    }
    @Override
    public long estimateSize() {
        return stockTickrList.size() - currentTickr;
    }
    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
