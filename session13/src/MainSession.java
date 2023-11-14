import java.util.Arrays;

public class MainSession {
    public static void main(String[] args) {
        saySomethingAndAnything(true);

        Bird[] birds = new Bird[] {new Bird(), new Chicken()};
        for (Bird bird : birds) {
            //bird.fly();
        }
    }

    // for the Liskov Substitution principle,
    // any base class should be successfully replaceable by any subclass
    // without breaking the application behavior.
    static class Bird { }

    static class NonFlyableBird extends Bird { }

    static class FlyableBird extends Bird {
        void fly() {
            System.out.println("flyinggg");
        }
    }

    // In order to avoid the violation of Liskov Substitution principle,
    // you can add an extra layer class to segregate the behaviors.
    static class Chicken extends NonFlyableBird { }

    abstract class Shape {
        abstract double computeArea();
    }

    class Circle extends Shape {

        private final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        double computeArea() {
            return Math.PI * Math.pow(radius, 2);
        }
    }

    class PrintingCircle extends Circle {

        PrintingCircle(double radius) {
            super(radius);
        }

        @Override
        double computeArea() {
            System.out.println("printing circle...");
            return super.computeArea();
        }
    }

    // for Single Responsibility Principle, a method, a class or a variable
    // should be used for a single scenario/responsability.
    public static void saySomethingAndAnything(boolean isSomething) {
        if (isSomething) {
            System.out.println("something");
        } else {
            System.out.println("anything");
        }

        System.out.println("done");
    }

    class Student {
        private double[] grade;

        public double computeAverage() {
            return Arrays.stream(grade).sum();
        }

        public double[] getGrade() {
            return grade;
        }
    }

    class Secretary {
        public double computeStudentAverage(Student student) {
            return Arrays.stream(student.getGrade()).sum();
        }
    }
}
