package encapsulation.library;

// regular public class syntax
// all classes extends Object class
public class Book {

    // encapsulated instance fields using 'private' access modifier
    private String name;
    private String author;

    // regular constructor syntax: access modifier and class name.
    // here we don't need a return type.
    // We also have some parameters to initialize our instance fields.
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    // here we have a regular setter.
    // the return type is void because here we just set a value for an instance field
    // the name can be something like 'set[VariableName]'
    // the parameter should regularly be the same type as the instance fields we wanna set.
    public void setName(String name) {
        this.name = name;
    }

    // this method comes from the Object class
    // we have here the same method signature
    // the method signature means the same return type, name and parameters
    // we mark it as override because we add a custom implementation in our class
    // this method is called by other methods when the string representation is intended.
    // the default behavior in the Object class is to print the fully qualified name (package + class name) + "@" + memory address
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    // private < default < protected < public
    // this method helps us to create deep copies for our objects.
    // deep copy means that we always create a new instance, we don't pass directly the reference.
    // the opposite is called shallow copy.
    // by default this method has the protected access modifier, but we can extend the scope in our implementation
    // also, we can't narrow down the access modifier, it's a compilation error.
    @Override
    public Object clone() {
        // this method just creates a new book having the characteristics of 'this' book.
        Book book = new Book(this.name, this.author);
        return book;
    }
}
