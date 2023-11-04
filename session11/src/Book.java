import java.util.Objects;

public class Book implements Comparable<Book> {

    private final String name;
    private int noOfPages;

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, int noOfPages) {
        this.name = name;
        this.noOfPages = noOfPages;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Book book) {
            return this.name.equals(book.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) + noOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", noOfPages=" + noOfPages +
                '}';
    }

    @Override
    public int compareTo(Book book) {
        if (this.noOfPages == book.noOfPages) {
            return 0;
        } else if (this.noOfPages < book.noOfPages) {
            return -1;
        }
        return 1;
    }
}
