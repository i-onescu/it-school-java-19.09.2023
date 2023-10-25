package interfaces;

public interface Interface2 {

    void doSomething();

    default void doSomethingElse() {
        System.out.println("Something else in Interface2");
    }
}
