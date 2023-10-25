package interfaces;

// in an interface we can have now both abstract methods,
// and 'default' marked methods.
// The 'default' marked methods allows the programmers to provide a default implementation for
// an inherited method.
public interface Interface1 {

    int x = 1;

    void doSomething();

    default void doSomethingElse() {
        System.out.println("do Something else in Interface1");
    }
}
