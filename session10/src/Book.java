import java.util.Objects;

public class Book {

    private String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }

    // !true = false
    // !false = true

    // short custom implementation of equals method
    @Override
    public boolean equals(Object o) {
        // since the method signature accepts an object as parameter,
        // we will first check if the passed is an instance of Book,
        // otherwise we will return false because it doesn't make any sense to continue to compare not matching types.
        if (!(o instanceof Book)) {
            return false;
        }

        // here we cast the received object to have access to the name instance variable.
        // if the name of the current object is equal to the passed object's name.
        return this.name.equals(((Book) o).name);
    }

    // returns an integer whose value represents the hash value of the input object.
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
