package com.example.exampleproject.pattern.factoryMethod;

public class Server extends Computer {
    private String ram;
    private String ssd;
    private String cpu;

    public Server(String ram, String ssd, String cpu) {
        this.ram = ram;
        this.ssd = ssd;
        this.cpu = cpu;
    }

    @Override
    public String getRam() {
        return this.ram;
    }

    @Override
    public String getSsd() {
        return this.ssd;
    }

    @Override
    public String getCpu() {
        return this.cpu;
    }
}
