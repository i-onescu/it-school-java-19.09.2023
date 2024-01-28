package designPatterns.src;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        DatabaseConnection instance1 = DatabaseConnection.getInstance();

        if (instance == instance1) {
            System.out.println("Singleton");
        } else {
            System.out.println("Different instances");
        }

        instance.printDbDetails();
        instance1.printDbDetails();
    }
}