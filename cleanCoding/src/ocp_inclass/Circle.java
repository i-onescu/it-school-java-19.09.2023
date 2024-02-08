package cleanCoding.src.ocp_inclass;

public class Circle implements Shape {
    @Override
    public String draw() {
        return "Drawing a circle...";
    }

    @Override
    public double getDiameter() {
        return 10;
    }
}
