package interfaces.generalInfo;

// this is a simple example of an interface
// the keyword is not 'class' anymore, and we must use 'interface'
// by default the methods are abstract, so they don't require any implementation
public interface MyInterface {

    // by default, the variables are public static final
    // this is why in IntelliJ we will see the 'public static final' combination being faded away.
    // this means that it's useless and might be removed as it is redundant.
    // for the 'final' marked variables in interfaces, we need to initialize them in-line.
    public static final int x = 1;

    // By default, methods are public, so it is redundant to be added in the method declaration
    // if we want to add the 'static' keyword, we must provide an implementation
    // as the 'static' marked variables or methods are not inherited in Java.
    // The 'final' keyword doesn't make sense to be added on an abstract method because it
    // prevents the programmer from extending the method leading to an "implementationless" method.
    public void doSomething();

    // We are not allowed to have private abstract methods, as they will end-up in being unimplemented.
    // private void doSomethingPrivate();
}
