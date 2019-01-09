package org.techrecipes.online.onlineshopping;
import org.techrecipes.online.utilityfunctions.Timeit;
import java.math.BigDecimal;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/**
 * Created by sjayapal on 3/30/2017.
 */
public class Shop {
    public static void main(String args[]) {
        Timeit.code(() -> {
            Shop shop = new Shop();
            System.out.println(shop.getPrice("12IyHat"));
        });
        long start = System.nanoTime();
        Shop shop = new Shop();
        Future<Double> future = shop.getPriceAsync("2YBat");
        System.out.println("Time taken with Future is " + (System.nanoTime() - start));
        doSomethingElse();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
    private static void doSomethingElse() {
        for (int i = 0; i < 500; i++) {
            System.out.println("My Long substitute " + i);
        }
    }
    public static void delay() {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException ite) {
            throw new RuntimeException(ite);
        }
    }
    public double getPrice(String product) {
        return calculatePrice(product);
    }
    private double calculatePrice(String product) {
        delay();
        System.out.println(product.charAt(0));
        return BigDecimal.valueOf(new Random().nextDouble())
                .multiply(BigDecimal.valueOf(product.charAt(0))).doubleValue();
    }
    public Future<Double> getPriceAsync(String product) {
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(product);
            completableFuture.complete(price);
        }).start();
        return completableFuture;
    }
}
