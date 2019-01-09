package org.techrecipes.online.abstract_factory;

public class SampleComputer {
    public static void main(String args[]) {
        ComputerA computerA = new ComputerA();
        ComputerB computerB = new ComputerB();
        createComputer(computerA);
        createComputer(computerB);
        System.out.println("Computer a " + computerA.toString());
        System.out.println("Computer b " + computerB.toString());
    }

    private static void createComputer(ComputerA computer) {
        computer.add(new CPUA());
        computer.add(new MemoryA());
    }

    private static void createComputer(ComputerB computer) {
        computer.add(new CPUB());
        computer.add(new MemoryB());
        System.out.println("THis is a change");
    }
}
