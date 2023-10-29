import abstractClasses.Woman;
import encapsulation.car.Car;
import encapsulation.human.Man;
import encapsulation.library.Book;
import encapsulation.library.Library;

public class Main {
    public static void main(String[] args) {
        // create an instance of Car
        Car car = new Car("Dacia", "albastru");
        printCarDetails(car);

        // set a value for an attribute.
        car.setBrand("Volkswagen");
        // we can check that the value for brand has been changed in the car instance.
        printCarDetails(car);

        car.setColor("Rosie");
        printCarDetails(car);

        car.setBrand("Nissan");
        printCarDetails(car);

        Man man = new Man("Bogdan", "brown");

        // since the String is immutable
        // if we extract the man's name in a variable, and that variable is altered
        // then the man's name is not changed, only the local variable.
        String name = man.getName();
        System.out.println(name);
        name = "TestName";

        System.out.println(man.getName());

        Book book1 = new Book("Book1", "Author1");
        Book book3 = book1; //shallow copy
        Book book4 = (Book) book1.clone(); //deep copy
        Book book2 = new Book("Book2", "Author2");

        Book[] books = new Book[]{ book1, book2 };

        Library library = new Library(books);
        printBooksFromLibrary(library);

        // since we have only deep copies in the library
        // then any change on the book1, which has been added to the library,
        // won't be reflected in the printBooksFromLibrary() method.
        book1.setName("Book3");
        printBooksFromLibrary(library);

    }

    private static void printBooksFromLibrary(Library library) {
        Book[] books = library.getBooks();
//        for (int i = 0; i < books.length; i++) {
//            System.out.println(books[i]);
//        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void printCarDetails(Car car) {
        System.out.println("Masina mea este " + car.getBrand() + " si are culoarea " + car.getColor() + ".");
    }
}
