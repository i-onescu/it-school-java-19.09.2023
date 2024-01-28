package designPatterns.src.factorymethod.factory;

import designPatterns.src.factorymethod.factory.abstr.VehicleFactory;
import designPatterns.src.factorymethod.model.Car;
import designPatterns.src.factorymethod.model.abstr.Vehicle;

public class CarFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
