package org.techrecipes.online.system;

public class SystemInfo {

    private int processors;
    private long memory;
    private long availMemory;

    public void checkCores(){
        processors = Runtime.getRuntime().availableProcessors();
        memory = Runtime.getRuntime().maxMemory();
        availMemory = Runtime.getRuntime().totalMemory();

    }

    @Override
    public String toString() {
        return "SystemInfo{" +
                "processors=" + processors +
                ", memory=" + memory +
                ", availMemory=" + availMemory +
                '}';
    }
}
