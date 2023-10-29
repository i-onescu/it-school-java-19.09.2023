package exercises;

// Write a Java program to create an abstract class Vehicle with a method called speedUp().
// Create two subclasses Car and Bicycle. Override the speedUp() method in each subclass to increase the vehicle's speed differently.

public class Main {

    public static void main(String[] args) {
        Vehicle car = new Car(0, 150);
        Vehicle bicycle = new Bicycle(0, 5);

        System.out.println(car);
        System.out.println(bicycle);

        car.speedUp();
        System.out.println(car);

        ((Bicycle) bicycle).speedUp("city");
        ((Bicycle) bicycle).speedUp("city");
        ((Bicycle) bicycle).speedUp("city");
        ((Bicycle) bicycle).speedUp("city");
        ((Bicycle) bicycle).speedUp("city");
        ((Bicycle) bicycle).speedUp("city");
        ((Bicycle) bicycle).speedUp("city");
        ((Bicycle) bicycle).speedUp("city");
        ((Bicycle) bicycle).speedUp("city");
        ((Bicycle) bicycle).speedUp("city");
        ((Bicycle) bicycle).speedUp("city");
        System.out.println(bicycle);
    }

}






