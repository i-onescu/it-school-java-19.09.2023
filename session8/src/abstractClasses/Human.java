package abstractClasses;

// The Human class is marked as being abstract,
// thus this class cannot be instantiated
// and can contain abstract methods wihtin it.
// Being an abstract class does not prevent the class from inheriting other classes.
// Also, even though it can't be instantiated, it allows constructors.
// The constructors help in the process of encapsulation.
public abstract class Human extends Animal {

    // these instance fields are marked as being private,
    // so we have access to them only inside Human class
    // they are not inherited by the child classes.
    // also, we can have access to them if we implement public getters in the parent class.
    // the same applies if we want to change values, we need public setters in the parent class.
    private int age;
    private String name;

    protected Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public abstract void sayHello();

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
