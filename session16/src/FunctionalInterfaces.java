import java.util.Random;

public class FunctionalInterfaces {

    public static void main(String[] args) {

        MyFunctionalInterface myFunctionalInterface = () -> System.out.println("Do something");
        myFunctionalInterface.doSomething();

        Test test = new Test();
        test.doSomething();

        MyFunctionalInterfaceWithReturnType mReturn = () -> "Do something";
        String s = mReturn.doSomething();

        System.out.println(s);

        MyFunctionalInterfaceWithOneArg mOneArg = x -> x + " is doing something";
        System.out.println(mOneArg.doSomething("Bogdan"));

        MyFunctionalInterfaceWithTwoArgs mTwoArgs = (x, y) -> x + " is doing " + y;
        // Specifying the param types
        //MyFunctionalInterfaceWithTwoArgs mTwoArgs = (String x, String y) -> x + " is doing " + y;
        System.out.println(mTwoArgs.doSomething("Bogdan", "yoga"));

        String y = "yoga";

        MyFunctionalInterfaceWithBody mBody = (x, z) -> {
            if (x.equals("Bogdan")) {
                z = "nothing";
            }
            return x + " is doing " + y;
        };

        System.out.println(mBody.doSomething("Bogdan", y));
        // lambda does not change the variable
        System.out.println(y);

        MyFunctionalInterfaceWithMRef mRef = System.out::println;
        mRef.doSomething("Bogdan");

        MyFunctionalInterfaceWithBody mBodyWithoutBody = FunctionalInterfaces::method;
        System.out.println(mBodyWithoutBody.doSomething("1", "2"));

        Random random = new Random();
        random.nextDouble(10);
    }

    private static String method(String x, String z) {
        if (x.equals("Bogdan")) {
            z = "nothing";
        }
        return x + " is doing " + z;
    }
}

class Test implements MyFunctionalInterface {

    @Override
    public void doSomething() {
        System.out.println("Do something");
    }
}
// no-args with void
@FunctionalInterface
interface MyFunctionalInterface {
    void doSomething();
}

// no-args with a return type
@FunctionalInterface
interface MyFunctionalInterfaceWithReturnType {
    String doSomething();
}

// one arg
@FunctionalInterface
interface MyFunctionalInterfaceWithOneArg {
    String doSomething(String s);
}

// two args
@FunctionalInterface
interface MyFunctionalInterfaceWithTwoArgs {
    String doSomething(String s, String s2);
}

// two args
@FunctionalInterface
interface MyFunctionalInterfaceWithBody {
    String doSomething(String s, String s2);
}

// method reference
@FunctionalInterface
interface MyFunctionalInterfaceWithMRef {
    void doSomething(String s);
}
