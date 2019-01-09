package org.techrecipes.online.forkjoinpool;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
/**
 * Created by sathishjayapal on 10/15/17.
 */
public class Sample {
    static int count = 0;
    static ExecutorService pool;
    public static boolean isPrime(int number) {
        boolean divisible = false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                divisible = true;
                break;
            }
        }
        return number > 1 && !divisible;
    }
    public static AtomicInteger functionalComputeInRange(int lower, int upper) {
        AtomicInteger count = new AtomicInteger();
        IntStream.rangeClosed(lower, upper).forEach(num -> {
            if (isPrime(num)) {
                count.incrementAndGet();
            }
        });
        return count;
    }
    public static long computeInRange(int lower, int upper) {
        System.out.println("Starting the prime number of " + lower + " and upper " + upper
                + " from  thread " + Thread.currentThread());
        long count = 0;
        for (int i = lower; i < upper; i++) {
            if (isPrime(i))
            {
                count++;
            }
        }
        return count;
    }
    public static long splitAndCompute(int lower, int upper)
            throws ExecutionException, InterruptedException {
        int difference = upper - lower;
        if (difference < 100) {
            return computeInRange(lower, upper);
        } else {
            int middle = lower + difference / 2;
            Future<Long> task1 = pool.submit(() -> {
                return computeInRange(lower, middle);
            });
            Future<Long> task2 = pool.submit(() -> computeInRange(middle + 1, upper));
            long returnVal = task1.get().longValue() + task2.get().longValue();
            System.out.println("Finishing the prime number of " + lower + " and upper " + upper
                    + " from  thread " + Thread.currentThread());
            return returnVal;
        }
    }
    public static void main(String args[]) throws InterruptedException, ExecutionException {
        pool = Executors.newFixedThreadPool(100);
        System.out.println(Sample.splitAndCompute(1, 1000));
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }
}
