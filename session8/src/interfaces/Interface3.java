package interfaces;

// An interface can support multiple inheritance (keyword here is 'extends')
// because any of the extended interfaces is not required to implement functionality.
// Compared to the classes situation where you are asked to provide an implementation for the abstract methods

// if there are two methods with the same signature and with 'default' marker
// then the implementing type, in this case 'Interface3' must add a custom implementation
// as the compiler is confused about which method should be used in any potential call.
public interface Interface3 extends Interface1, Interface2 {

    default void testMultipleInheritance() {
        this.doSomethingElse();
    }

    // this will help us to get rid of the confusion.
    @Override
    default void doSomethingElse() {
        // this line will tell us that we want to use the implementation from Interface1.
        Interface1.super.doSomethingElse();
    }
}
