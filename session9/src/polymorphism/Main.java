package polymorphism;

public class Main {

    public static void main(String[] args) {
//
//        Animal animal = new Animal();
//        animal.makeSomeNoise();
//
//        Cat cat = new Cat();
//        cat.makeSomeNoise();
//
//        cat.sayHello();
//        cat.sayHello(1);
//        cat.sayHello(1, 4);

//        Animal cat2 = new Cat();
//        Animal dog = new Dog();
//        Animal animal2 = new Animal();
//
//        animal2.makeSomeNoise();
//        cat2.makeSomeNoise();
//
//        ((Cat) cat2).sayHello();
//
//        ((Dog) dog).bark();
//        ((Dog) cat2).bark();

        Animal dog = new Dog();
        Animal cat = new Cat();

        Animal[] animals = new Animal[] {dog, cat};
//
//        Dog[] dogs = new Dog[] {new Dog(), new Dog()};
//        Cat[] cats = new Cat[] {new Cat()};

        for (Animal animal : animals) {
            if (animal instanceof Dog) {
                Dog innerDog = (Dog) animal;
                innerDog.bark();
            } else if (animal instanceof Cat) {
                Cat innerCat = (Cat) animal;
                innerCat.sayHello();
            }
        }

        // <=>

        for (Animal animal : animals) {
            if (animal instanceof Dog innerDog) {
                innerDog.bark();
            } else if (animal instanceof Cat innerCat) {
                innerCat.sayHello();
            }
        }
    }
}

abstract class Animal {
    private int age;
    private String name;

    public void makeSomeNoise() {
        System.out.println("Animal noise");
    }
}

class Dog extends Animal {
    private String propertyDog;

    public void bark() {
        System.out.println("barking...");
    }
}

class Cat extends Animal {
    private String propertyCat;

    @Override
    public void makeSomeNoise() {
        System.out.println("meow");
    }

    // we can have multiple methods with the same name,
    // while they have different number of parameters

    //Method Signature is the combination of a method's name and its parameter list.
    public void sayHello() {
        System.out.println("Hello");
    }

    public void sayHello(int x) {
        System.out.println("String " + x);
    }

    public void sayHello(int x, int y) {
        System.out.println("x = " + x + ", y = " + y);
    }
}
