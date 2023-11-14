import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

interface MyInterface {
    void saySomething();
}

class MyOtherClass implements MyInterface {

    @Override
    public void saySomething() {
        System.out.println("something");
    }
}

class MyOtherOtherClass implements MyInterface {

    @Override
    public void saySomething() {
        System.out.println("something in my otherOther class");
    }
}

// Using the 'extends' keyword at class level
// we let the clients use this class with any type extending 'MyInterface'
// for example 'MyOtherClass' and 'MyOtherOtherClass'
class MyOtherGenericClass<T extends MyInterface> {
    private final T myField;

    MyOtherGenericClass(T myField) {
        this.myField = myField;
        this.myField.saySomething();
    }

    public T getMyField() {
        return myField;
    }
}

class SuperSuperClass {}
class SuperClass extends SuperSuperClass {}
class Class extends SuperClass {}

public class Generics {
    public static void main(String[] args) {
        // Example of multiple generics passed.
        MyClass<Integer, String, Date> myClassInteger =
                new MyClass<>(1, new Date());

        // if we don't use the '<>' operator we are exposed to runtime exceptions
        // in the bellow case, even though I am passing the first generic as 'Integer'
        // I am passing to the constructor a string for it.
        // But the compiler allows me this in a raw use of generic classes.
        MyClass<Integer, String, Date> myClassString =
                new MyClass("string", LocalDateTime.now());

        System.out.println(myClassInteger.getMyField());
        System.out.println(myClassString.getMyField());

        myClassString.saySomething(new Date());

        MyOtherGenericClass<MyOtherClass> myOtherGenericClass =
                new MyOtherGenericClass<>(new MyOtherClass());

        myOtherGenericClass.getMyField().saySomething();

        MyOtherGenericClass<MyOtherOtherClass> myOtherOtherGenericClass =
                new MyOtherGenericClass<>(new MyOtherOtherClass());

        myOtherOtherGenericClass.getMyField().saySomething();

        // We can use the 'super' keyword in variables declaration
        // and we can read it as any type that has as super type the 'MyInterface' class/interface
        MyOtherGenericClass<? super MyInterface> myOtherGenericClassSecond =
                new MyOtherGenericClass<>(new MyOtherOtherClass());

        // this is related to the example with 'extends' for parameters
        List<Integer> integers = new ArrayList<>();
        double sum = doSum(integers);
        System.out.println(sum);

        // we can also use 'extends', but here we can read it as
        // allowing types which Number class extends.
        // we are not allowed to add any elements to such a list,
        // because Java won't be able to know the possible implementations.
        List<? extends Number> myList = new ArrayList<>();
        List<? super Number> myListSuper = new ArrayList<>();

        myListSuper.add(1);
        myListSuper.add(1L);

        // myList.add(1);

        // Here we have used a constant value declared in the 'Color' enum
        // and we passed it in the TShirt class constructor.
        TShirt tShirt = new TShirt(Color.GREEN);
        System.out.println(tShirt);

        // when you are not sure of the generic type, you can use the '?' wildcard.
        // this will remove the warning of using raw types for generic classes.
        // here we firstly have a list of integers
        List<?> values = returnSomeList();
        System.out.println(values);
        // now we changed the list into a list of strings
        // this is a very powerful tool, but can lead to serious runtime problems.
        values = returnOtherList();
        System.out.println(values);
    }

    static List<Integer> returnSomeList() {
        return List.of(1, 2, 3);
    }

    static List<String> returnOtherList() {
        return List.of("str", "dvsv", "sdcs");
    }

    // enums can be declared in separate files
    // they need the enum keyword, equivalent to the 'class' and 'interface' keywords
    enum Color {
        // enums hold constant values
        // this kind of values must be written with capital letters (just a recommendation)
        // the below syntax works like calling a constructor which also accepts parameters
        RED("color red", 23),
        YELLOW("color yellow", 34),
        BLUE("color blue", 54),
        GREEN("color green", 676),
        BLACK("color black", 564),
        // if there is nothing else coming after finishing the enum values,
        // then the semicolon is not mandatory
        WHITE("color white", 3943);

        // enums can also contain parameters, following the same encapsulation principles
        // as those used in classes.
        private final String colorText;
        private final int colorCode;

        // this is an example of constructor for enums
        Color(String colorText, int colorCode) {
            this.colorText = colorText;
            this.colorCode = colorCode;
        }

        @Override
        public String toString() {
            return "Color{" +
                    "colorText='" + colorText + '\'' +
                    ", colorCode=" + colorCode +
                    '}';
        }
    }

    static class TShirt {
        // we can use Enums as regular classes
        // and to pass it as type of instance fields, return types and method parameters.
        private Color color;

        public TShirt(Color color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "TShirt{" +
                    "color='" + color + '\'' +
                    '}';
        }
    }

    // the 'extends' keyword can be used in generic declaration together with the '?' wildcard
    // to mark the bound of accepted types.
    // In conclusion, the following method will accept Integers, Doubles, Floats etc...
    public static double doSum(List<? extends Number> numbers) {
        double sum = 0;

        for (Number number : numbers) {
            sum += number.doubleValue();
        }

        return sum;
    }
}

// The below is the syntax of defining generics at class level
// you can have as many generics you want
class MyClass<T, K, V> {
    // because the 'T' type is declared at class level,
    // you are able to access it everywhere within the class
    private T myField;
    private Object otherField;

    // we can have generics defined at method level or constructor level
    // this sort of generics can be accessed only within the method or constructor
    public <S> MyClass(T myField,
                       S otherField) {
        this.myField = myField;
        this.otherField = otherField;
    }

    // we can use this newly declared type as return type.
    public T getMyField() {
        return myField;
    }

    public void setMyField(T myField) {
        this.myField = myField;
    }

    // you can also reuse the same letter in different context
    // note that if you reuse 'T' which is declared at a higher level
    // it will hide the upper level one.
    public <S> S saySomething(S someParam) {
        System.out.println(someParam);
        return someParam;
    }
}
