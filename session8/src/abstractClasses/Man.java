package abstractClasses;

public class Man extends Human {

    // we can have 'final' marked fields within a class
    // based on the type of variable (i.e. instance fields or static fields) we need to initialize it before using it
    // in case of static fields we must use the in-line initialization, or a 'static block' (search about it)
    // basically we need to initialize it in the moment of class loading process.
    private static final int x = 1;
    // Note: the private static final variables should be named like (naming convention, not mandatory):
    //          MESSAGE_SOMETHING (capital letters and '_' used for words separation).
    private static final String PARAMETER_NAME = "parameter";

    // if we have an instance field marked as being 'final', then we are allowed to initialize it in the ctor
    // why is that? because we need an instance anyway to call an instance field.
    // it's not enough to have only one ctor handling the 'y' initialization, as all ctor should take care of this issue.
    // on the other hand, we can still have the in-line initialization, but not both as the variable is final, so unchangeable.
    private final int y;

    // Because the Human class is providing a custom ctor with two parameters,
    // the Man class is required to have a matching constructors.
    // As we know by default, Java is providing a default ctor without any parameters
    // and a call to super(); Also, the same applies for any ctor, the first line will
    // always be by default super();, in our case, this signature for the super ctor
    // does not exist in the parent class meaning that we need to write it manually.
    public Man(int age, String name, int y) {
        super(age, name);
        this.y = y;
    }

    // so what we care about to be compliant with the parent ctor is not the
    // signature of the child class ctor, but the actual call to the super ctor
    // in this ctor we just correctly call the parent class ctor with some hard-coded parameters.
    public Man() {
        super(1, "ss");
        this.y = 1;
    }

    // as Man class is the first concrete class in the classes hierarchy,
    // we must add an implementation for this method
    @Override
    public void sayHello() {
        System.out.println("Hello, I am a man.");
    }

    // the same applies for this method;
    // even though the Man class is not inheriting directly the Animal class,
    // it is passed transitively through the Human class to Man class
    @Override
    public void breath() {
        System.out.println("Man's breathing...");
    }
}
