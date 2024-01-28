package designPatterns.src.factorymethod.model;

import designPatterns.src.factorymethod.model.abstr.Vehicle;

public class Car extends Vehicle {
    @Override
    public void build() {
        System.out.println("Building a car...");
    }
}
