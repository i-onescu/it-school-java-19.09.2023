package exercises;

public class Car extends Vehicle {

    private final int hp;

    protected Car(int currentSpeed, int hp) {
        super(currentSpeed);
        this.hp = hp;
    }

    @Override
    protected void speedUp() {
        System.out.println("Speeding up the car...");
        this.setCurrentSpeed(this.getCurrentSpeed() + 10);
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "Car{" +
                "hp=" + hp +
                ";currentSpeed=" + this.getCurrentSpeed() +
                '}';
    }
}
