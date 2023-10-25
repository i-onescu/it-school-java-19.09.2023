package encapsulation.human;

// all humans are animals
public class Human extends Animal {

    private String name;
    private String hairColor;

    public Human(String name, String hairColor) {
        this.name = name;
        this.hairColor = hairColor;
    }

    public String getName() {
        return name;
    }
}
