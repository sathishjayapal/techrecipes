package org.techrecipes.online.forkjoinpattern;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
/**
 * Created by sjayapal on 5/2/2017.
 */
public class RecursiveTaskGenerator extends RecursiveTask {
    public static void main(String args[]) {
        ForkJoinTask task = new RecursiveTaskGenerator();
        new ForkJoinPool().invoke(task);
    }
    @Override
    protected Object compute() {
        System.out.println("Trying to take some baby steps here");
        return 0;
    }
}
