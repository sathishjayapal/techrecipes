package org.techrecipes.online.abstract_factory;

public abstract class Computer {
    private CPU cpu;
    private Memory memory;

    public void add(CPU cpu) {
        this.cpu = cpu;
    }

    public void add(Memory memory) {
        this.memory = memory;
    }

    @Override
    public String toString() {
        return String.format("This is the  computer  %s  %s %s \n", getClass(), cpu, memory);
    }
}
