package designPatterns.src.builder;

public class Car {

    private String color;
    private String model;
    private final String brand;
    private final Integer hp;
    private Integer engineCapacity;
    private Float price;
    private Float weight;

    private Car(String brand, Integer hp) {
        this.brand = brand;
        this.hp = hp;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    public Float getPrice() {
        return price;
    }

    public Float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", hp=" + hp +
                ", engineCapacity=" + engineCapacity +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }

    public static class CarBuilder {
        private final Car car;

        public CarBuilder(String brand, Integer hp) {
            car = new Car(brand, hp);
        }

        public CarBuilder color(String color) {
            car.color = color;
            return this;
        }

        public CarBuilder model(String model) {
            car.model = model;
            return this;
        }

        public CarBuilder price(Float price) {
            car.price = price;
            return this;
        }

        public CarBuilder weight(Float weight) {
            car.weight = weight;
            return this;
        }

        public CarBuilder engineCapacity(Integer engineCapacity) {
            car.engineCapacity = engineCapacity;
            return this;
        }

        public Car build() {
            return this.car;
        }
    }
}
