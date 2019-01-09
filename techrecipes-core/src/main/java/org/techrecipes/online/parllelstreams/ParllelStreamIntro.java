package org.techrecipes.online.parllelstreams;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Created by sjayapal on 5/22/2017.
 */
public class ParllelStreamIntro {
    public static int findNumberOfProcessorsInMachine() {
        System.out.println(Runtime.getRuntime().availableProcessors());
        return Runtime.getRuntime().availableProcessors();
        //Employ concurrency is speed. The other option is giving them a responsive information.
    }
    public static void process(int start, int end) {
        System.out.println("Processsing from.. " + start + "_... to " + end);
        try {
            Thread.sleep(5000);
        } catch (Exception intr) {
            System.out.println("Interupted to the process handling method");
        }
    }
    public static void main(String args[]) {
        int availableProcessors = ParllelStreamIntro.findNumberOfProcessorsInMachine();
        int value = 100000;
        System.out.println("In Sequential");
        process(1, value);
        System.out.println("In Parllerl");
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < availableProcessors; i++) {
            int start = i * (value / availableProcessors) + 1;
            int end = (i + 1) * (value / availableProcessors);
            executorService.submit(() -> process(start, end));
            System.out.println("Starting at " + start + " and ending at " + end);
        }
    }
}
