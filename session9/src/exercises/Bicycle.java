package exercises;

public class Bicycle extends Vehicle {

    private final int gears;

    protected Bicycle(int currentSpeed, int gears) {
        super(currentSpeed);
        this.gears = gears;
    }

    @Override
    protected void speedUp() {
        System.out.println("Speeding up the bicycle...");
        this.setCurrentSpeed(this.getCurrentSpeed() + 5);
    }

    protected void speedUp(String area) {
        System.out.println("Trying to speed up the bicycle in are " + area);
        if ("city".equals(area)
                && this.getCurrentSpeed() < 48) {
            this.speedUp();
        } else {
            System.out.println("Can't speed up in the city");
        }
    }

    public int getGears() {
        return gears;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "gears=" + gears +
                ";currentSpeed=" + this.getCurrentSpeed() +
                '}';
    }
}
