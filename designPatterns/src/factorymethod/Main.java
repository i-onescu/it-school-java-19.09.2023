package designPatterns.src.factorymethod;

import factorymethod.factory.CarFactory;
import factorymethod.factory.MotorcycleFactory;
import factorymethod.factory.abstr.VehicleFactory;
import factorymethod.model.Car;
import factorymethod.model.Motorcycle;
import factorymethod.model.abstr.Vehicle;

public class Main {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        carFactory.buildVehicle();

        VehicleFactory motoFactory = new MotorcycleFactory();
        motoFactory.buildVehicle();

        Vehicle motorcycle = createVehicles("motorcycle");
        Vehicle car = createVehicles("car");

        car.build();
        motorcycle.build();
    }
    
    private static Vehicle createVehicles(String type) {
        return switch (type) {
            case "car" -> new Car();
            case "motorcycle" -> new Motorcycle();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}
