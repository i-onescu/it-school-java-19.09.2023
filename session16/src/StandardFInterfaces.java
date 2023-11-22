import java.util.Random;
import java.util.function.*;

public class StandardFInterfaces {

    public static void main(String[] args) {

        Predicate<String> checkIfStringIsNotEmpty = o -> o != null && !o.isEmpty();

        boolean test = checkIfStringIsNotEmpty.test("Bogdan");
        System.out.println(test);

        boolean testNull = checkIfStringIsNotEmpty.test(null);
        System.out.println(testNull);

        Predicate<String> andPredicate =
                checkIfStringIsNotEmpty.and(s -> s != null && s.length() > 3);

        System.out.println(andPredicate.test("Bogdan"));
        System.out.println(andPredicate.test("Jon"));

        Consumer<String> printString =
                s -> System.out.println("I received a variable with value " + s);

        printString.accept("someValue");

        Function<String, Integer> myFunction = s -> {
            if (s != null) {
                return s.length();
            }
            return -1;
        };

        Integer bogdan = myFunction.apply("Bogdan");
        System.out.println(bogdan);

        Supplier<Integer> mySupplier = () -> new Random().nextInt(10);

        Integer int1 = mySupplier.get();
        Integer int2 = mySupplier.get();
        Integer int3 = mySupplier.get();

        System.out.println("Sum of random numbers = " + (int1 + int2 + int3));

        // using specialized interfaces
        ToIntFunction<String> myFunctionSecond = s -> {
            if (s != null) {
                return s.length();
            }
            return -1;
        };

        Integer bogdanSecond = myFunctionSecond.applyAsInt("Bogdan");
        System.out.println(bogdanSecond);

        IntSupplier mySupplierSecond = () -> new Random().nextInt(10);

        Integer int4 = mySupplierSecond.getAsInt();
        Integer int5 = mySupplierSecond.getAsInt();
        Integer int6 = mySupplierSecond.getAsInt();

        System.out.println("Sum of random numbers = " + (int4 + int5 + int6));

        UnaryOperator<String> myUnaryOperator = s -> "Some string " + s;
        String unaryOperatorValue = myUnaryOperator.apply("Bogdan");

        System.out.println(unaryOperatorValue);

        BinaryOperator<String> myBinaryOperator = (s1, s2) -> s1 + s2;
        System.out.println(myBinaryOperator.apply("str1", "str2"));
    }
}
