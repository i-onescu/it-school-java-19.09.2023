package cleanCoding.src.ocp_inclass;

public class Rectangle implements Shape {

    @Override
    public String draw() {
        return "drawing a rectangle";
    }

    @Override
    public double getDiameter() {
        throw new UnsupportedOperationException("cant get diameter");
    }
}
