package cleanCoding.src.ocp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();

        shapeList.add(new Circle());
        shapeList.add(new Rectangle());

        for (Shape shape : shapeList) {
            System.out.println(shape.getDiameter());
        }
    }
}