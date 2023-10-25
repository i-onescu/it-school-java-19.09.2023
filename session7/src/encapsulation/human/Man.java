package encapsulation.human;

// because Human class has a custom constructor, we must then call the super constructor in the subclass.
public class Man extends Human {
    public Man(String name, String hairColor) {
        super(name, hairColor);
    }
}
