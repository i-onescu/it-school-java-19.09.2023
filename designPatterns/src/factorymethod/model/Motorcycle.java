package designPatterns.src.factorymethod.model;

import designPatterns.src.factorymethod.model.abstr.Vehicle;

public class Motorcycle extends Vehicle {
    @Override
    public void build() {
        System.out.println("Building a motorcycle...");
    }
}
