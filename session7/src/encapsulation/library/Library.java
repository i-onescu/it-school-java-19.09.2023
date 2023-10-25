package encapsulation.library;

public class Library {

    // we can have arrays of objects
    private Book[] books;

    // here we don't directly pass the reference to the array parameter,
    // but we create a deep copy for our array
    public Library(Book[] books) {
        this.books = new Book[books.length];

        // the same here, we don't directly pass the array elements,
        // but we create a copy for each book
        for (int i = 0; i < books.length; i++) {
            this.books[i] = (Book) books[i].clone();
        }
    }

    // if we want to make our class a little bit more immutable,
    // we should've returned a copy of our array.
    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
