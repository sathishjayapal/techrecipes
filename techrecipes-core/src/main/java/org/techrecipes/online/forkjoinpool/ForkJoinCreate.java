package org.techrecipes.online.forkjoinpool;

import org.techrecipes.online.file_utils.CsvFileReader;

import java.util.concurrent.ForkJoinPool;

import static java.util.concurrent.ForkJoinPool.commonPool;

public class ForkJoinCreate {
    public static void readCSVWork() {
        System.out.println("The thread am using is "+Thread.currentThread());
        CsvFileReader fileReader= new CsvFileReader();
        fileReader.readCSVFile("/Users/skminfotech/IdeaProjects/techrecipes/techrecipes-core/src/main/resources/CsvFileReaderTestData.csv");
    }
    public static void writeCSVWork() {
        System.out.println("The thread am using is "+Thread.currentThread());
        CsvFileReader fileReader= new CsvFileReader();
        fileReader.readCSVFile("/Users/skminfotech/IdeaProjects/techrecipes/techrecipes-core/src/main/resources/CsvFileReaderTestData.csv");
    }

    private static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
            return true;
        } catch (InterruptedException interruptedException) {
            return false;
        }
    }

    public static void main(String[] args) {
        var forkJoinPool = ForkJoinPool.commonPool();
        for (int i = 0; i < 100; i++) {
            forkJoinPool.submit(() -> doWork());
        }
        forkJoinPool.shutdown();
        sleep(2000);
    }

}
