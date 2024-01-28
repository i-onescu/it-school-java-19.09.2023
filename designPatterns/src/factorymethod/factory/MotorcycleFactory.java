package designPatterns.src.factorymethod.factory;


import designPatterns.src.factorymethod.factory.abstr.VehicleFactory;
import designPatterns.src.factorymethod.model.Motorcycle;
import designPatterns.src.factorymethod.model.abstr.Vehicle;

public class MotorcycleFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Motorcycle();
    }
}
