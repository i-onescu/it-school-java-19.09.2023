package encapsulation.car;

public class Car {

    private String brand;
    private String color;

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    // in this setter we have a validation
    // if the validation fails, then the brand is not changed
    public void setBrand(String brand) {
        for (int i = 0; i < CarBrand.brands.length; i++) {
            if (CarBrand.brands[i].equals(brand)) {
                this.brand = brand;
                break;
            }
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
