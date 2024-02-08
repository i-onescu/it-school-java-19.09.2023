package cleanCoding.src.ocp_inclass;

public class Drawer {

    public String drawShape(String shapeType) {
        return switch (shapeType) {
            case "circle" -> "drawing a circle";
            case "rectangle" -> "dranwing a rectangle";
            default -> "default";
        };
    }
}
