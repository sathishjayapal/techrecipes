package org.techrecipes.online.utilityfunctions;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Created by sathishjayapal on 4/16/16.
 */
public class ExecutorServiceSample {
    public static void main(String args[]) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i <= 10000; i++) {
            executorService.submit(() -> System.out
                    .println("Coming to the executor service " + Thread.currentThread().getName()));
        }
        executorService.shutdown();
        System.out.println("In main " + Thread.currentThread());
    }
}
