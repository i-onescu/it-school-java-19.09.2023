package designPatterns.src.builder;

public class Main {

    public static void main(String[] args) {

        Car.CarBuilder bmwBuilder = new Car.CarBuilder("BMW", 200);
        Car bmw = bmwBuilder.color("black")
                .price(15000f)
                .model("X6")
                .engineCapacity(3000)
                .weight(2000f)
                .build();

        System.out.println(bmw.getBrand());
    }
}
