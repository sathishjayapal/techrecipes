package org.techrecipes.online.functional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;
import org.techrecipes.online.utilityfunctions.Timeit;
public class FunctionalSample1 {
  static LongAdder longAdder=new LongAdder();
    public static void main(String args[]) throws InterruptedException, ExecutionException {
      FunctionalSample1 functionalSample1 = new FunctionalSample1();
      Timeit.code(() -> functionalSample1.runMethodImpl());
    }
  public void runMethodImpl() {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        System.out.println(forkJoinPool);
        IntStream.rangeClosed(0, 1000000)
                .forEach(str -> forkJoinPool.submit(() -> callableTask(String.valueOf(str))));
        forkJoinPool.shutdown();
        System.out.println("The final long adder" +longAdder);
    }
  public void callableTask(String input) {
    longAdder.increment();
    System.out.println("Checking value of long adder " + longAdder);
    System.out.println("Printing for " + input + "in thread " + Thread.currentThread());
    }
}
