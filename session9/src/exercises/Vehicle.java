package exercises;

public abstract class Vehicle {
    private int currentSpeed;

    protected Vehicle(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    protected abstract void speedUp();

    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public void setCurrentSpeed(int speed) {
        this.currentSpeed = speed;
    }
}