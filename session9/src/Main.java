public class Main {
    public static void main(String[] args) {
        // we can instantiate 'Man' and 'Woman' by using the 'Human' type variables
        // since all 'Man's and 'Woman's are 'Human'

        // Note here that we are not able to access sub-class specific methods
        // we are able to see only the inherited properties and methods
        // also, in case of methods, any call on the 'myMan' instance will call the 'Man' implementation
        Human myMan = new Man("John", 21);
        Human myWoman = new Woman("Jane", 21);

        // We need Object Type Casting to enable sub-class specific methods.
        ((Woman) myMan).saySomething();

        // We can have an array of humans, meaning that it can contain any kind of sub-class of human
        // it works the same way as it does with primitives
        // for better understanding think the arrays as being a list/enumeration of objects
        Human[] humans = new Human[] {myMan, myWoman};

        // we can use enhanced for, and the regular one to iterate over the array.
        for (Human human : humans) {
            // we can use the 'instanceof' operator in order to avoid the runtime 'ClassCastException'
            // for example, if we try to cast 'myMan' to 'Woman' class,
            // there won't be any compilation error, but a runtime exception thrown since these two type are inconvertible
            if (human instanceof Man h) {
                // since Java 14, there is a feature called Pattern Matching which allows you to declare in-line variables
                // if the condition returns true
                // so 'h' variable is only accessible in the 'if' context, meaning that an outside of if (the true branch)
                // we are not able to access the 'h' variable
                h.sayHello();
            } else if (human instanceof Woman h) {
                h.saySomething();
            }
        }
    }
}

// Here we have a regular concrete class
// note that we can have multiple classes within a single .java document
class Man extends Human {

    // matching constructor according to Human constructor
    public Man(String name, int age) {
        super(name, age);
    }

    public void sayHello() {
        System.out.println("hello");
    }
}

class Woman extends Human {

    public Woman(String name, int age) {
        super(name, age);
    }

    public void saySomething() {
        System.out.println("something");
    }
}

class Human {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
