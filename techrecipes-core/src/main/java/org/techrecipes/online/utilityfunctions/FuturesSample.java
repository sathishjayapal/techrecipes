package org.techrecipes.online.utilityfunctions;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/**
 * Created by sjayapal on 3/30/2017.
 */
public class FuturesSample {
    public static void main(String args[]) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Double> doubleFuture = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return doSomeLongComputation();
            }
        });
        doSomethingelse();
        try {
            Double result = doubleFuture.get(1, TimeUnit.SECONDS);
            System.out.println("The result is " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
    private static void doSomethingelse() {
        Timeit.code(() -> {
            for (int i = 0; i < 500; i++) {
                System.out.println("My Long substitute " + i);
            }
        });
    }
    private static Double doSomeLongComputation() {
        Timeit.code(() -> {
            for (int i = 0; i < 500; i++) {
                System.out.println("My Long computation is " + i);
            }
        });
        return 0.00;
    }
}
