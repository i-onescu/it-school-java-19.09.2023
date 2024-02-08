package cleanCoding.src.ocp;

public interface Shape {
    void draw();
    int getDiameter();
}

class Circle implements Shape {
    @Override
    public void draw() {
        // drawing a circle
    }

    @Override
    public int getDiameter() {
        return 0;
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        // drawing a rectangle
    }

    @Override
    public int getDiameter() {
        throw new UnsupportedOperationException("Can't get the diameter of a rectangle");
    }
}
