package com.example.exampleproject.pattern.factoryMethod;

public class ComputerMainTest {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC", "2GB", "500GB", "2.4GHz");
        System.out.println("pc = " + pc.toString());

    }
}
