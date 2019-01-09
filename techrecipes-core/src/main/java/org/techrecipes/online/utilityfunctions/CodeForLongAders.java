package org.techrecipes.online.utilityfunctions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
public class CodeForLongAders {
  static LongAdder count;
  static ExecutorService pool;
  public static void main(String args[]) throws InterruptedException, ExecutionException {
    pool = Executors.newFixedThreadPool(100);
    CodeForLongAders.splitAndCompute(1, 1000);
    System.out.println("The count to be considered is "+count);
    pool.shutdown();
    pool.awaitTermination(1, TimeUnit.MINUTES);
  }
  private static void splitAndCompute(int lowerRange, int higherRange ) {
    for(int i=lowerRange;i<higherRange;i++) {
      pool.submit(() -> count.increment());
    }
  }
}
