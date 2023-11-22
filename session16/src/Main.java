public class Main {
    public static void main(String[] args) {
        Book book = new Book("author1", "name1");
        book.readBook();

        CustomBook customBook = new CustomBook("author2", "name2", "romantic");
        customBook.readBook();

        Book lambdaBook = new Book("author3", "name3") {
            @Override
            public void readBook() {
                System.out.println("Reading book with genre romantic.");
            }
        };

        lambdaBook.readBook();

        Drawable drawable = new Drawable() {
            @Override
            public void draw() {
                System.out.println("Drawing a circle.");
            }
        };

        drawable.draw();
    }
}

class Book {
    private String author;
    private String name;

    public Book(String author, String name) {
        this.author = author;
        this.name = name;
    }

    public void readBook() {
        System.out.println("Reading book with name " + name + " by " + author + ".");
    }
}

class CustomBook extends Book {
    private String genre;

    public CustomBook(String author,
                      String name,
                      String genre) {
        super(author, name);
        this.genre = genre;
    }

    @Override
    public void readBook() {
        System.out.println("Reading book with genre " + genre + ".");
    }
}

interface Drawable {
    void draw();
}
