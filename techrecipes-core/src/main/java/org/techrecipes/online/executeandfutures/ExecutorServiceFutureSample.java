package org.techrecipes.online.executeandfutures;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
public class ExecutorServiceFutureSample {
  public static void main(String args[])
      throws InterruptedException, ExecutionException, IOException {
    ExecutorServiceFutureSample executorServiceFutureSample = new ExecutorServiceFutureSample();
    Integer result;
    result = executorServiceFutureSample.futureAPIUsageSample2();
    }
    private static Integer processSample2() throws InterruptedException {
      System.out.println("Starting the process " + Thread.currentThread());
        return 2;
    }
    static void sleep(Long longSleep) throws InterruptedException {
        Thread.sleep(longSleep);
    }
    private static void futureAPIUsageSample1() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Future<Integer> result = executorService.submit(() -> processSample2());
        System.out.println("Result call before sleep " + result.isDone());
        sleep(40000L);
        System.out.println("Result call after sleep " + result.isDone());
        executorService.awaitTermination(10, TimeUnit.SECONDS);
      executorService.shutdown();
        System.out.println("in main waiting for the result " + result.get());
    }
  private Integer futureAPIUsageSample2()
      throws InterruptedException, ExecutionException, IOException {
    ExecutorService executorService = Executors.newFixedThreadPool(100);
    Files.list(Paths.get("/volumes/Segate HDD/iTunes Media/"))
        .forEach(str -> executorService.submit(() -> {
            try {
              System.out.println(
                  "The return value in thread " + Thread.currentThread() + "File name is " + str);
              ExecutorServiceFutureSample.sleep(2000L);
              return 0;
            } catch (InterruptedException e) {
                System.out.println("My thread was interupted");
              return -1;
            }
        }));
        executorService.shutdown();
        executorService.awaitTermination(100L, TimeUnit.SECONDS);
    return -1;
    }
}
