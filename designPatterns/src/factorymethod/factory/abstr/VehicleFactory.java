package designPatterns.src.factorymethod.factory.abstr;

import designPatterns.src.factorymethod.model.abstr.Vehicle;

public abstract class VehicleFactory {

    public Vehicle buildVehicle() {
        Vehicle vehicle = createVehicle();
        vehicle.build();

        return vehicle;
    }

    protected abstract Vehicle createVehicle();
}
