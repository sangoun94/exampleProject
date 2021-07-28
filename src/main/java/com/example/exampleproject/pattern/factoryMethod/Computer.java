package com.example.exampleproject.pattern.factoryMethod;

public abstract class Computer {
    public abstract String getRam();
    public abstract String getSsd();
    public abstract String getCpu();

    @Override
    public String toString() {
        return "ra"+getRam();
    }
}
