package com.example.exampleproject.pattern.factoryMethod;

public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String ssd, String cpu) {
        if (type == "SERVER") {
            Server server = new Server(ram, ssd, cpu);
            return server;
        } else if (type == "PC") {
            Pc pc = new Pc(ram, ssd, cpu);
            return pc;
        }
        return null;
    }
}
